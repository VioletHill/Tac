package TacNotices;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataSource.Notices.AllNotices;
import DataSource.Notices.Notices;

public class NoticesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public NoticesServlet() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int index=0;
		int totNotices=0;
		AllNotices allNotices=AllNotices.sharedAllNotices();
		try 
		{
			index=Integer.parseInt(request.getParameter("index"));
		} 
		catch (Exception e) 
		{
			index=-1;
		}
		
		if (index>=0)
		{
			
		}
		else 
		{
			String search;
			try 
			{
				search=new String(request.getParameter("search").getBytes("iso-8859-1"),"gbk");
			} catch (Exception e) 
			{
				search="";
			}
		}
		
		totNotices=allNotices.getAllNotices().size();
		
		request.setAttribute("allNotices", allNotices);
		request.setAttribute("totNotices", totNotices);
		request.getRequestDispatcher("/TacNotices/Notices.jsp").forward(request, response);
		
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



}
