package TacHonor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataSource.Projects.AllProjects;

public class ProjectPageServlet extends HttpServlet {

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
		String id=request.getParameter("id");
		
		//此处处理 id 的异常
		int proId=-1;
		try {
			proId=Integer.parseInt(id);
		} catch (Exception e) {
	
			System.err.println("wrong address input!  go to errorPage");
		}
		AllProjects allProjects=new AllProjects();
		
		if (proId<0 || proId>=allProjects.getProject().size())
		{
			request.getRequestDispatcher("/ErrorPage/ErrorPage.html").forward(request, response);
		}
		else 
		{
			request.setAttribute("project", allProjects.getProject().get(proId));
			request.getRequestDispatcher("/TacHonor/ProjectPage.jsp").forward(request, response);
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
			throws ServletException, IOException {
		doGet(request, response);
	}

}
