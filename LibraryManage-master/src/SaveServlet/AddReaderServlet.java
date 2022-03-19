package SaveServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.MysqlLinking;

@WebServlet(name = "AddReaderServlet",urlPatterns ="/AddReaderServlet")//娉ㄩ噴
public class AddReaderServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;

}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Class.forName("com.mysql.jdbc.Driver");
 		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/reader?useUnicode=true&characterEncoding=UTF-8", "root", "");
 	 try {
				response.setContentType("text/html");
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				String rName = request.getParameter("rName");
				String rsex = request.getParameter("rsex");
				String rage = request.getParameter("rage");
				String rClass = request.getParameter("rClass");
				String rSort = request.getParameter("rSort");
				String rNo = request.getParameter("rNo");
				String rPhoneNum = request.getParameter("rPhoneNum");				
		   	 if (conn != null) {
					try {
										
						String sql="insert into reader(rNo,rName,rsex,rage,rClass,rSort,rPhoneNum,password,lendNum,canLendNum) values(?,?,?,?,?,?,?,?,?,?)"; 
					
						PreparedStatement ps = conn.prepareStatement(sql);
						
						ps.setString(1,rNo);
					   	ps.setString(2,rName);
					   	ps.setString(3,rsex);
					   	ps.setInt(4,Integer.valueOf(rage));
					   	ps.setString(5,rClass);	   	 
					   	ps.setString(6,rSort);
					   	ps.setString(7,rPhoneNum);	
					   	ps.setString(8,"123456");
					   	ps.setInt(9, 0);
					   	ps.setInt(10, 10);
						//鎵ц鏇存柊鎿嶄綔
					   	ps.executeUpdate();					
						//鑾峰彇PrintWriter瀵硅薄
						PrintWriter out = response.getWriter();//杈撳嚭缁撴灉淇℃伅																								
						out.println("<script language='javascript'>");
						out.println("var str='鐢ㄦ埛娣诲姞鎴愬姛锛侀粯璁ゅ瘑鐮佹槸123456,璇风櫥褰曚慨鏀癸紒';");//榛樿瀵嗙爜鏄�'123456',璇风櫥褰曚慨鏀癸紒
						out.println("alert(str);");								
						out.println("window.navigate('AddReader.jsp');");
						out.println("</script>");	
						out.flush();
						out.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					
					response.sendError(500, "鏁版嵁搴撹繛鎺ラ敊璇紒");
				}
 	





