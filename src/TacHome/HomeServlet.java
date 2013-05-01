package TacHome;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataSource.Notices.AllNotices;
import DataSource.Notices.NoticesHibernate;
import DataSource.Projects.AllProjects;


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
		//String userName=request.getParameter("userName");
		//String userPassword=request.getParameter("userPassword");
		AllProjects allProjects=AllProjects.sharedAllProjects();
		
		AllNotices allNotices=new AllNotices();
		allNotices.setList(NoticesHibernate.sharedNoticesHibernate().find_All(0, 4));
		
		request.setAttribute("allProjects", allProjects);
		request.setAttribute("allNotices", allNotices);
		
		if (!allNotices.getAllNotices().isEmpty())
		{
			request.setAttribute("firstNotice", NoticesHibernate.sharedNoticesHibernate().find_ById(allNotices.getAllNotices().get(0).getNotice_id()));
		}
		else 
		{
			request.setAttribute("firstNotice",null);
		}
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
