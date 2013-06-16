package TacDocument;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import DataSource.Document.DocumentData;

public class DocumentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DocumentServlet() {
		super();
	}

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

		// //String userName=request.getParameter("userName");
		// //String userPassword=request.getParameter("userPassword");
		// AllProjects allProjects=AllProjects.sharedAllProjects();
		// // AllNotices allNotices=AllNotices.sharedAllNotices();
		// request.setAttribute("allProjects", allProjects);
		// // request.setAttribute("allNotices", allNotices);
		//
		System.out.println("server started");
		DocumentData data = new DocumentData();
		//data.setPageNum(Integer.parseInt(request.getParameter("page")));
		data.setDataOfPage(1);
		String searchKey = "";
		String catalog = "all";
		boolean isFirst = true;
		try 
		{
			String doneAnything = request.getParameter("doSomething");
			if (doneAnything.equals("yes")) 
			{
				isFirst = false;
			}
		}
		catch (Exception e) 
		{
			isFirst = true;
		}

		if (isFirst) 
		{
			data.setPageIndex(1);
		}
		else 
		{
			// 获取页数
			try 
			{
				data.setPageIndex(Integer.parseInt(request
						.getParameter("pageIndex")));
			}
			catch (Exception e) 
			{
				data.setPageIndex(1);
			}
		}

		// 获取搜索信息
		try 
		{
			searchKey = new String(request.getParameter("search").getBytes("iso-8859-1"), "gbk");
			int start = 0;
			int end = searchKey.length();
			while (start < searchKey.length() && searchKey.charAt(start) == ' ')
				start++;
			while (end >= 0 && searchKey.charAt(end - 1) == ' ')
				end--;
			searchKey = searchKey.substring(start, end);
		} 
		catch (Exception e) 
		{
			searchKey = "";
		}
		
		// 获取类别
		try 
		{
			catalog = new String(request.getParameter("catalog").getBytes("iso-8859-1"), "gbk");
		} 
		catch (Exception e) 
		{
			catalog = "all";
		}
		
		//searchKey = "测试";
		//catalog = "lib";
		System.out.println("data refresh started");
		System.out.println(searchKey+" "+catalog);
		data.setDataWithSearchKeyOfCatalog(searchKey, catalog);
		//System.out.println(data.getDataList());
//		System.out.println(data.getTitle(0));
		request.setAttribute("DocumentData", data);
		request.getRequestDispatcher("/TacDocument/Document.jsp").forward(
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
