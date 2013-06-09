package TacHome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataSource.User.User;
import DataSource.User.UserHibernate;

public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public Login() {
		super();
	}


	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String account=null;
		String password=null;
		
		try 
		{
			account=request.getParameter("account");
			password=request.getParameter("password");
			
			if (UserHibernate.sharedUserHibernate().judge_login(account, password))
			{
				out.write("true");
				User user=UserHibernate.sharedUserHibernate().find_by_account(account);
				HttpSession session=request.getSession();
				session.setAttribute("account", account);
				session.setAttribute("headAdd", user.getHeader_add());
				session.setAttribute("isLog", true);
			}
			else 
			{
				out.write("false");
			}
		} 
		catch (Exception e) 
		{
			out.write("false");
		}
		out.flush();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
