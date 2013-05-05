package TacNotices.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataSource.Notices.Notice;
import DataSource.Notices.NoticesHibernate;

public class UpdateNotices extends HttpServlet {

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
		//AllNotices allNotices=AllNotices.sharedAllNotices();
		
		String title=new String(request.getParameter("title").getBytes("iso-8859-1"),"gbk");
		String content=new String(request.getParameter("publish_content").getBytes("iso-8859-1"),"gbk");
		
		Notice notice=new Notice();

		notice.setNotice_html(content);
		notice.setNotice_title(title);
		
		NoticesHibernate.sharedNoticesHibernate().choose(notice);
		//Ìø×ª»ØÖ÷Ò³
		response.sendRedirect("Home");
		
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
