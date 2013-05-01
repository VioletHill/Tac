package TacNotices;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataSource.Notices.AllNotices;
import DataSource.Notices.Notices;

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
		AllNotices allNotices=AllNotices.sharedAllNotices();

		Notices newNotices=new Notices();
		
		SimpleDateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd");
	
		
		String title=new String(request.getParameter("title").getBytes("iso-8859-1"),"gbk");
		String content=new String(request.getParameter("publish_content").getBytes("iso-8859-1"),"gbk");
		newNotices.setData(dataFormat.format(new Date()));
		newNotices.setTitle(title);
	
		newNotices.setContent(content);
		allNotices.addNotices(newNotices);
		
//		Notice notice=new Notice();
//		notice.setNotice_id(1);
//		notice.setNotice_html(content);
//		Session session=HibernateSessionFactory.getSession();
//		Transaction  transaction=session.beginTransaction();
//		session.save(notice);
//		transaction.commit();
//		session.flush();
//		session.close();

		//Ìø×ª»ØÖ÷Ò³
		response.sendRedirect("http://localhost:8080/Tac/Home");
		
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
