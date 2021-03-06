package TacHome;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataSource.Honor.AllHonor;
import DataSource.Honor.HonorHibernate;
import DataSource.Notices.AllNotices;
import DataSource.Notices.NoticesHibernate;


public class HomeServlet extends HttpServlet {

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
		AllHonor allHonor=new AllHonor();
		allHonor.setList(HonorHibernate.sharedNoticesHibernate().find_honor(16, 1));
		
		AllNotices allNotices=new AllNotices();
		allNotices.setList(NoticesHibernate.sharedNoticesHibernate().find_All(1, 4));
		
		request.setAttribute("allHonor", allHonor);
		request.setAttribute("allNotices", allNotices);
		
		request.getRequestDispatcher("/TacHome/Home.jsp").forward(request, response);
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
