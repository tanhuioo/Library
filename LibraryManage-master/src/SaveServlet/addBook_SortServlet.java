package SaveServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.BookSort;
import com.lyq.bean.MysqlLinking;

@WebServlet(name="addBook_SortServlet",urlPatterns="/addBook_SortServlet")//娉ㄩ噴
public class addBook_SortServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;  
	
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 Class.forName("com.mysql.jdbc.Driver");
    		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/booksort?useUnicode=true&characterEncoding=UTF-8", "root", "");
    	 try {
    	   response.setContentType("text/html");
	       request.setCharacterEncoding("UTF-8");
	       response.setCharacterEncoding("UTF-8");	      	
		   List<BookSort> bslist=new ArrayList<>();
	   	   if (conn != null) {
				try {							
					String sql="select * from booksort "; //鑾峰緱鍥句功绫诲瀷锛屽湪鍥句功绫诲瀷涓嬫媺鑿滃崟涓緭鍑�				
					PreparedStatement ps = conn.prepareStatement(sql);	//鍒涘缓PreparedStatement瀵硅薄												   	
					ResultSet rs=ps.executeQuery();						
					while(rs.next()){	
						BookSort bs=new BookSort();
						bs.setBooksort((rs.getString("bSort")));
						bslist.add(bs);//鎶婁繚瀛樺浘涔︾被鍨嬪湪bslist闆嗗悎涓�
					}
					
					request.setAttribute("bslist", bslist);		//鎶奲slist瀛樻斁鍦╮equest瀵硅薄涓�		
					request.getRequestDispatcher("/AddBook.jsp").forward(request, response);//杞埌AddBook.jsp椤甸潰				                			
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
