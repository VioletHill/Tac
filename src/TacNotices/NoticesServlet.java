package TacNotices;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.dialect.function.VarArgsSQLFunction;

import DataSource.Notices.AllNotices;
import DataSource.Notices.NoticesHibernate;

public class NoticesServlet extends HttpServlet {

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
		final int pageNum = 10;

		String search = "";

		NoticesHibernate noticesHibernate = NoticesHibernate
				.sharedNoticesHibernate();
		AllNotices allNotices = new AllNotices();

		boolean isFirst = false;
		try {
			String isSearch = request.getParameter("isSearch");
			if (isSearch.equals("yes")) {
				isFirst = true;
			}
		} catch (Exception e) {
			isFirst = false;
		}

		if (isFirst) {
			allNotices.setPageIndex(1);
		} else {
			// 获取页数
			try {
				allNotices.setPageIndex(Integer.parseInt(request
						.getParameter("pageIndex")));
			} catch (Exception e) {
				allNotices.setPageIndex(1);
			}
		}

		// 获取搜索信息
		try {
			search = new String(request.getParameter("search").getBytes(
					"iso-8859-1"), "gbk");
			int start = 0;
			int end = search.length();
			while (start < search.length() && search.charAt(start) == ' ')
				start++;
			while (end >= 0 && search.charAt(end - 1) == ' ')
				end--;
			search = search.substring(start, end);
		} catch (Exception e) {
			search = "";
		}

		// 获取时间
		try {
			allNotices.setNoticeTime(new String(request.getParameter(
					"searchTime").getBytes("iso-8859-1"), "gbk"));
		} catch (Exception e) {
			allNotices.setNoticeTime("all");
		}
		System.out.print(allNotices.getNoticeTime());
		/*
		 * //////////////////////////////////////////////////////////华丽分割线///////
		 * ///////////
		 */
		if (allNotices.getNoticeTime().equals("month")) {
			System.out.print("month");
			if (search == "") {
				allNotices
						.setAllPage((noticesHibernate.find_number_ByMonth() - 1)
								/ pageNum + 1);
				allNotices.setList(noticesHibernate.find_ByMonth(
						allNotices.getPageIndex(), pageNum));
				allNotices.setSearch("搜索信息");
			} else {
				allNotices.setAllPage((noticesHibernate
						.search_number_ByMonth(search) - 1) / pageNum + 1);
				allNotices.setList(noticesHibernate.search_ByMonth(search,
						allNotices.getPageIndex(), pageNum));
				allNotices.setSearch(search);
			}
			allNotices.setNoticeTime("本月");
		} else if (allNotices.getNoticeTime().equals("week")) {
			System.out.print("week");
			if (search == "") {
				allNotices
						.setAllPage((noticesHibernate.find_number_ByWeek() - 1)
								/ pageNum + 1);
				allNotices.setList(noticesHibernate.find_ByWeek(
						allNotices.getPageIndex(), pageNum));
				allNotices.setSearch("搜索信息");
			} else {
				allNotices.setAllPage((noticesHibernate
						.search_number_ByWeek(search) - 1) / pageNum + 1);
				allNotices.setList(noticesHibernate.search_ByWeek(search,
						allNotices.getPageIndex(), pageNum));
				allNotices.setSearch(search);
			}
			allNotices.setNoticeTime("本周");
		} else if (allNotices.getNoticeTime().equals("today")) {
			System.out.print("day");
			if (search == "") {
				allNotices
						.setAllPage((noticesHibernate.find_number_ByDay() - 1)
								/ pageNum + 1);
				allNotices.setList(noticesHibernate.find_ByDay(
						allNotices.getPageIndex(), pageNum));
				allNotices.setSearch("搜索信息");
			} else {
				allNotices.setAllPage((noticesHibernate
						.search_number_ByDay(search) - 1) / pageNum + 1);
				allNotices.setList(noticesHibernate.search_ByDay(search,
						allNotices.getPageIndex(), pageNum));
				allNotices.setSearch(search);
			}
			allNotices.setNoticeTime("今日");
		} else // all
		{
			if (search == "") {
				allNotices.setAllPage((noticesHibernate.find_number_All() - 1)
						/ pageNum + 1);
				allNotices.setList(noticesHibernate.find_All(
						allNotices.getPageIndex(), pageNum));
				allNotices.setSearch("搜索信息");
			} else {
				allNotices
						.setAllPage((noticesHibernate.search_number(search) - 1)
								/ pageNum + 1);
				allNotices.setList(noticesHibernate.search(search,
						allNotices.getPageIndex(), pageNum));
				allNotices.setSearch(search);
			}
			allNotices.setNoticeTime("全部");
		}

		request.setAttribute("allNotices", allNotices);
		request.getRequestDispatcher("/TacNotices/Notices.jsp").forward(
				request, response);

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
