package TacNotices;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataSource.Notices.AllNotices;
import DataSource.Notices.Notices;

public class EditIndexNotices extends HttpServlet {

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
		
		int index=-1;
		AllNotices allNotices=AllNotices.sharedAllNotices();
		try 
		{
			index=Integer.parseInt(request.getParameter("index"));
		} 
		catch (Exception e) 
		{
			System.out.println("No this index! goto create new");
		}
		if (index<0 || index>=allNotices.getAllNotices().size())	//添加一个新的页面
		{
			Notices notices=new Notices();
			notices.setTitle("此处添加新标题");
			request.setAttribute("notices",notices);
			request.getRequestDispatcher("/TacNotices/Admin/UpdateNotices.jsp").forward(request, response);
		}
		else 
		{
			request.setAttribute("notices",allNotices.getAllNotices().get(index));
			request.getRequestDispatcher("/TacNotices/Admin/UpdateNotices.jsp").forward(request, response);
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
