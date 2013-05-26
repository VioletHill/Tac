package TacRegister;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataSource.User.User;


public class Register extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
			throws ServletException, IOException 
	{	
		String account;
		String password;
		String email;
		String phone;
		String isRegister;
		
		try
		{
			account=request.getParameter("account");
			password=request.getParameter("password");
			email=request.getParameter("email");
			phone=request.getParameter("phone");
			
			isRegister=request.getParameter("isRegister");
			
		
			if (isRegister.equals("false"))
			{
				response.setContentType("text/html; charset=gbk");
				
				//ºÏ≤‚’À∫≈ ±∫Ú±ª◊¢≤·
				PrintWriter out = response.getWriter();
				//if (User.get.) out.write("true");
				out.write("true");
				//else out.write("false");
				out.flush();
		
				return ;
			}
			
			
			
			User user=new User();
			user.setAccount(account);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhone(phone);
			
		
			
		}
		catch (Exception e) 
		{
			log("can not read the user");
			request.getRequestDispatcher("/ErrorPage/ErrorPage.html").forward(request, response);
			return ;
		}
		
		
		
		
		
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
			throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
