package TacMessageBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataSource.Message.Message;
import DataSource.Message.MessageHibernate;

public class Publish extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Publish() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/MessageBoard").forward(request, response);
		return;
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf8");
		
		HttpSession session = request.getSession();
		if (session.getAttribute("isLog")==null || session.getAttribute("isLog").equals(false)) {
			response.sendRedirect("/Tac/ErrorPage/LoginFirst.jsp"); 
			return ;
		} 
		String account = (String) session.getAttribute("account");
				
		String content = request.getParameter("content");
		content = content.replaceAll("&","&amp;");
		content = content.replaceAll(" ","&nbsp;");
		content = content.replaceAll("<","&lt;");
		content = content.replaceAll(">","&gt;");
		content = content.replaceAll("\n","&nbsp;");
		content = content.replaceAll("\"","&quot;");
		content = content.replaceAll("\'","&#39;");
		
		Message message = new Message();
		message.setContent(content);
//		message.setPicture(null);
//		message.setTime(null);
		message.setUser_account(account);
		if (!MessageHibernate.sharedMessageHibernate().insert(message)) {
			//error
			response.sendRedirect("/Tac/ErrorPage/ErrorPage.html");
		} else {
			response.sendRedirect("/Tac/MessageBoard");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
