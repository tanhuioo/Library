 package SaveServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lyq.bean.MysqlLinking;

@WebServlet(name = "LoginServlet",urlPatterns ="/LoginServlet")//娉ㄩ噴閰嶇疆鏂囦欢
public class LoginServlet extends HttpServlet {
	    private Connection conn=null;
		private static final long serialVersionUID = 1L;
		  
		public void init(ServletConfig config) throws ServletException {
			 (new MysqlLinking()).getLink();//
	    	 conn=MysqlLinking.conn;//	    			
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String Usersort = request.getParameter("UserSort");	
			String username = request.getParameter("username");			
			String pwd = request.getParameter("pwd");			    
			HttpSession session = request.getSession();			
	   	 if (conn!= null) {
				try {	
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/reader?useUnicode=true&characterEncoding=UTF-8", "root", "");
					java.sql.Statement stmt=conn.createStatement();		
					String sql="select * from reader where rName=? and password=?"; 				
					PreparedStatement ps = conn.prepareStatement(sql);				
					ps.setString(1, username);	
					ps.setString(2, pwd);	
					ResultSet rs=ps.executeQuery();	
					String Uname="";
					String Pdw="";
					String usersort="";
					while(rs.next()){							
						Uname=rs.getString("rName");  
						Pdw=rs.getString("password");
						usersort=rs.getString("rSort");
												
						String RNO=rs.getString("rNo");	
						session.setAttribute("RNO",RNO);
						String NAME=Uname;
						session.setAttribute("NAME",NAME);
						String RSORT=usersort;
						session.setAttribute("RSORT",RSORT);
					}
					if(Uname.equals(username) && Pdw.equals(pwd)){
						if(usersort.equals(Usersort) && usersort.equals("绠＄悊鍛�")){
							request.getRequestDispatcher("/M_HomePage.jsp").forward(request, response);
						}
						else if(usersort.equals(Usersort) && usersort.equals("瀛︾敓")){
							request.getRequestDispatcher("/R_HomePage.jsp").forward(request, response);
						}
						else{
							PrintWriter out = response.getWriter();					
							out.println("<script language='javascript'>");
							out.println("var str='鐢ㄦ埛绫诲埆閿欒锛佽閲嶆柊杈撳叆锛�';");
							out.println("alert(str);");	
							out.println("window.navigate('index.jsp');");
							out.println("</script>");										
							out.flush();
							out.close();						
						}
					}
					else{//鐢ㄦ埛鍚嶆垨瀵嗙爜閿欒
						PrintWriter out = response.getWriter();					
						out.println("<script language='javascript'>");
						out.println("var str='鐢ㄦ埛鍚嶆垨瀵嗙爜閿欒锛佽閲嶆柊杈撳叆锛�';");
						out.println("alert(str);");	
						out.println("window.navigate('index.jsp');");
						out.println("</script>");										
						out.flush();
						out.close();						
					}			
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			} 
	   	    else {
				//鍙戦�佹暟鎹簱杩炴帴閿欒鎻愮ず淇℃伅
				response.sendError(500, "鏁版嵁搴撹繛鎺ラ敊璇紒");
			}
		}

}
