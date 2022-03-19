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

@WebServlet(name="addBookSortServlet",urlPatterns="/addBookSortServlet")//娉ㄩ噴
public class addBookSortServlet extends HttpServlet {
	private Connection conn=null;
	private static final long serialVersionUID = 1L;
      
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	   Class.forName("com.mysql.jdbc.Driver");
 		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/booksort?useUnicode=true&characterEncoding=UTF-8", "root", "");
 	 try {
		if (conn != null) {
   		    response.setContentType("text/html");
		    request.setCharacterEncoding("UTF-8");
		    response.setCharacterEncoding("UTF-8");
   		    String bt=request.getParameter("bsort");//鑾峰緱琛ㄥ崟灞炴�у浘涔︾被鍨�
			try {				
				String sql="insert into booksort(bSort) values(?)"; //娣诲姞鍥句功绫诲瀷
				PreparedStatement ps = conn.prepareStatement(sql);	
				ps.setString(1, bt);
				ps.executeUpdate();	
				
				PrintWriter out = response.getWriter();
							
				out.println("<script language='javascript'>");
				out.println("var str='鍥句功绫诲埆娣诲姞鎴愬姛锛�';");
				out.println("alert(str);");	
				out.println("window.navigate('booksort.jsp');");
				out.println("</script>");	
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			//鍙戦�佹暟鎹簱杩炴帴閿欒鎻愮ず淇℃伅
			response.sendError(500, "鏁版嵁搴撹繛鎺ラ敊璇紒");
		}
	}


}
