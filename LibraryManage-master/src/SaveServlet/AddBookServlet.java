package SaveServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.MysqlLinking;

@WebServlet(name = "AddBookServlet",urlPatterns ="/AddBookServlet")//娉ㄩ噴
public class AddBookServlet extends HttpServlet {
	private Connection conn=null;
	private static final long serialVersionUID = 1L;
      
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	 Class.forName("com.mysql.jdbc.Driver");
 	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/books?useUnicode=true&characterEncoding=UTF-8", "root", "");
 	 try {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String bName = request.getParameter("bName");//鑾峰彇琛ㄥ崟涓睘鎬у��
		String writer = request.getParameter("writer");
		String press = request.getParameter("press");
		String presstime = request.getParameter("presstime");
		String price = request.getParameter("price");
		String pageNum = request.getParameter("pageNum");
		String sort = request.getParameter("sort");
		String barCode = request.getParameter("barCode");
   	 if (conn != null) {
			try {
				//鎻掑叆娉ㄥ唽淇℃伅鐨凷QL璇彞(浣跨敤?鍗犱綅绗�)	 //娣诲姞鍥句功灞炴��			
				String sql="insert into books(bName,writer,press,presstime,price,pageNum,sort,barCode,LendNum,state,borrower) values(?,?,?,?,?,?,?,?,?,?,?)"; 
				//鍒涘缓PreparedStatement瀵硅薄
				PreparedStatement ps = conn.prepareStatement(sql);
				//瀵筍QL璇彞涓殑鍙傛暟鍔ㄦ�佽祴鍊�
				ps.setString(1,bName);
			   	ps.setString(2,writer);
			   	ps.setString(3,press);
			   	ps.setString(4,presstime);
			   	ps.setDouble(5,Double.valueOf(price));			   	 
			   	ps.setInt(6,Integer.valueOf(pageNum));
			   	ps.setString(7,sort);
			   	ps.setString(8,barCode);
			   	ps.setInt(9,0);
			   	ps.setString(10,"鏈��");
			   	ps.setString(11,"");
				//鎵ц鏇存柊鎿嶄綔
			   	 ps.executeUpdate();				
				//鑾峰彇PrintWriter瀵硅薄
				PrintWriter out = response.getWriter();
				//杈撳嚭娉ㄥ唽缁撴灉淇℃伅				
				out.println("<script language='javascript'>");
				out.println("var str='鍥句功娣诲姞鎴愬姛锛�';");
				out.println("alert(str);");	
				out.println("window.navigate('AddBook.jsp');");
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
