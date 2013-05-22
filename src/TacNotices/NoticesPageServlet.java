package TacNotices;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataSource.Notices.Notice;
import DataSource.Notices.NoticesHibernate;

public class NoticesPageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

		String id = request.getParameter("indexNotices");
		// 此处处理 id 的异常
		int noticeId = -1;
		try {
			noticeId = Integer.parseInt(id);
		} catch (Exception e) {

			System.err.println("wrong address input!  go to errorPage");
		}

		Notice notice = NoticesHibernate.sharedNoticesHibernate().find_ById(
				noticeId);

		if (notice == null) {
			request.getRequestDispatcher("/ErrorPage/ErrorPage.html").forward(
					request, response);
		} else {
			request.setAttribute("notice", notice);
			request.getRequestDispatcher("/TacNotices/NoticesPage.jsp")
					.forward(request, response);
		}
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

		doGet(request, response);
	}

}
