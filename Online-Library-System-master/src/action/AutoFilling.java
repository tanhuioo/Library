package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AutoFilling
 */
@WebServlet("/AutoFilling ")
public class AutoFilling extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutoFilling() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = request.getParameter("param");
		System.out.println(userId);
		Cookie[] cookies = request.getCookies();
		Cookie accountCookie = null;
		boolean has = false;
		if (cookies != null) {// 鍚湁cookie
			System.out.println("--AutoFilling--,--doGet()--,cookie瀛樺湪");
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("account")) {
					System.out.println("--AutoFilling--,--doGet()--,鍚湁淇濆瓨璐﹀彿鐨刢ookie");
					has = true;
					accountCookie = cookie;
					break;
				}
			}
			if (has) {// 鍚湁鎵�闇�cookie
				String cookieValue = accountCookie.getValue();
				if (cookieValue.contains("&")) {// 鏈夊涓猘ccount
					System.out.println("--AutoFilling--,--doGet()--,鍚湁澶氫釜璐﹀彿");
					String[] accounts = cookieValue.split("&");
					for (int i = 0; i < accounts.length; i++) {
						if (accounts[i].split("=")[0].equals(userId)) {// 鍦╟ookie涓壘鍒伴�変腑鐨剈serID
							String password = accounts[i].split("=")[1];
							String authority = accounts[i].split("=")[2];
							System.out.println("--AutoFilling--,--doGet()--,userId=" + userId);
							System.out.println("--AutoFilling--,--doGet()--,password=" + password);
							System.out.println("--AutoFilling--,--doGet()--,authority=" + authority);
							request.setAttribute("userId", userId);
							request.setAttribute("password", password);
							request.setAttribute("authority", authority);
							break;
						}
					}
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				} else {// 浠呮湁涓�涓猘ccount
					System.out.println("--AutoFilling--,--doGet()--,浠呮湁涓�涓处鍙�");
					if (cookieValue.split("=")[0].equals(userId)) {// 鍦╟ookie涓壘鍒伴�変腑鐨剈serID
						String password = cookieValue.split("=")[1];
						String authority = cookieValue.split("=")[2];
						System.out.println("--AutoFilling--,--doGet()--,userId=" + userId);
						System.out.println("--AutoFilling--,--doGet()--,password=" + password);
						System.out.println("--AutoFilling--,--doGet()--,authority=" + authority);
						request.setAttribute("userId", userId);
						request.setAttribute("password", password);
						request.setAttribute("authority", authority);
					}
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}
			} else {// 涓嶅惈鏈夋墍闇�cookie
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		} else {// 鏃燾ookie
			System.out.println("--AutoFilling--,--doGet()--,鏃燾ookie");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
