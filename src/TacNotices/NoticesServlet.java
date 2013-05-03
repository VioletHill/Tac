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
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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
		String search="";
		
		NoticesHibernate noticesHibernate=NoticesHibernate.sharedNoticesHibernate();
		AllNotices allNotices=new AllNotices();
		
		try 
		{
			allNotices.setPageIndex(Integer.parseInt(request.getParameter("pageIndex")));
		} 
		catch (Exception e) 
		{
			allNotices.setPageIndex(0);
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
			System.out.println(request.getParameter("noticeTime"));
			//allNotices.setNotieceTime(new String(request.getParameter("noticeTime").getBytes("iso-8859-1"),"gbk"));
		} 
		catch (Exception e) 
		{
			allNotices.setNoticeTime("全部");
		}
		
//		if (allNotices.getNotieceTime()=="全部") System.out.print("all");
//		else if (allNotices.getNotieceTime()=="本周") System.out.print("week");
		
		
		if (allNotices.getPageIndex()>0)
		{
			
		}
		else 
		{
			
			
			if (search=="")
			{
				allNotices.setList(noticesHibernate.find_All(0, 10));
			}
			else 
			{
				allNotices.setList(noticesHibernate.search(search, 0, 10));
			}
		}

		//
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
