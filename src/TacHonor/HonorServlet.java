package TacHonor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataSource.Honor.AllHonor;
import DataSource.Honor.Honor;
import DataSource.Honor.HonorHibernate;

public class HonorServlet extends HttpServlet {

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
			throws ServletException, IOException {
		
		final int pageNum=16;
		AllHonor allHonor=new AllHonor();
		// »ñÈ¡Ò³Êý
		try 
		{
			allHonor.setPage(Integer.parseInt(request.getParameter("pageIndex")));
		}
		catch (Exception e) 
		{
			allHonor.setPage(1);
		}
		allHonor.setList(HonorHibernate.sharedNoticesHibernate().find_honor(pageNum, allHonor.getPage()));
		allHonor.setAllPage((HonorHibernate.sharedNoticesHibernate().Honor_number()-1)/pageNum+1);
		
		request.setAttribute("allHonor",allHonor);
		request.getRequestDispatcher("/TacHonor/Honor.jsp").forward(request, response);
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
