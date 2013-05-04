package TacNotices.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataSource.Notices.Notice;
import DataSource.Notices.NoticesHibernate;

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
		
		try 
		{
			index=Integer.parseInt(request.getParameter("index"));
		} 
		catch (Exception e) 
		{
			
		}
		Notice notice=NoticesHibernate.sharedNoticesHibernate().finb_ById(index);
		
		if (notice==null)	//添加一个新的页面
		{
			System.out.println("No this index! goto create new");
			notice=new Notice();
			notice.setNotice_title("此处添加新标题");
			notice.setNotice_html(null);
			notice.setNotice_id(0);
			request.setAttribute("notice",notice);
			request.getRequestDispatcher("/TacNotices/Admin/UpdateNotices.jsp").forward(request, response);
		}
		else 
		{
			request.setAttribute("notice",notice);
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
