package TacNotices;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final int pageNum=10;
		
		
		String search="";
		
		NoticesHibernate noticesHibernate=NoticesHibernate.sharedNoticesHibernate();
		AllNotices allNotices=new AllNotices();
		
		try 
		{
			allNotices.setPageIndex(Integer.parseInt(request.getParameter("pageIndex")));
		} 
		catch (Exception e) 
		{
			allNotices.setPageIndex(1);
		}
		
		try 
		{
			search=new String(request.getParameter("search").getBytes("iso-8859-1"),"gbk");
			int start=0;
			int end=search.length();
			while (start<search.length() && search.charAt(start)==' ') start++;
			while (end>=0 && search.charAt(end-1)==' ') end--;
			search=search.substring(start, end);
		} 
		catch (Exception e) 
		{
			search="";
		}
		
		try 
		{
			allNotices.setNoticeTime(new String(request.getParameter("searchTime").getBytes("iso-8859-1"),"gbk"));
		} 
		catch (Exception e) 
		{
			allNotices.setNoticeTime("all");
		}
		
	/*  //////////////////////////////////////////////////////////华丽分割线////////////////// */
		if (allNotices.getNoticeTime()=="month")
		{
			if (search=="")
			{
				//allNotices.setTotAllNotices(noticesHibernate.find_number_All());
				//allNotices.setList(noticesHibernate.find_ByMonth(pageNum, pageNum, pageNum);
				allNotices.setSearch("搜索信息");
			}
			else 
			{
				allNotices.setTotAllNotices(noticesHibernate.search_number(search));
				allNotices.setList(noticesHibernate.search(search, allNotices.getPageIndex(), pageNum));
			}
		}
		else if (allNotices.getNoticeTime()=="week")
		{
		}
		else if (allNotices.getNoticeTime()=="today")
		{
			
		}
		else 	//all
		{
			if (search=="")
			{
				System.out.println("no search");
				allNotices.setTotAllNotices(noticesHibernate.find_number_All());
				allNotices.setList(noticesHibernate.find_All(allNotices.getPageIndex(), pageNum));
				allNotices.setSearch("搜索信息");
			}
			else 
			{
				System.out.println(search);
				allNotices.setTotAllNotices(noticesHibernate.search_number(search));
				allNotices.setList(noticesHibernate.search(search, allNotices.getPageIndex(), pageNum));
				allNotices.setSearch(search);
			}
			allNotices.setNoticeTime("全部");
		}
		
		allNotices.setTotAllNotices(noticesHibernate.find_number_All());
		request.setAttribute("allNotices", allNotices);
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
