package TacHibernate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import TacHibernateSessionFactory.HibernateSessionFactory;

public class HibernateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HibernateServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void insert(Notice notice)
	{
		NoticeDAO dao=new NoticeDAO();
		Calendar cal=Calendar.getInstance();
		notice.setNotice_year(cal.get(Calendar.YEAR));
		notice.setNotice_month(cal.get(Calendar.MONTH)+1);
		notice.setNotice_week(cal.get(Calendar.WEEK_OF_YEAR));
		notice.setNotice_day(cal.get(Calendar.DAY_OF_MONTH));
		dao.save(notice);
	}
	public void update(Notice notice)
	{
		Session session=HibernateSessionFactory.getSession();
		String hql="update Notice n set n.notice_html=?,n.notice_title=? where n.notice_id=?";
		Query query=session.createQuery(hql);
		query.setString(0, notice.getNotice_html());
		query.setString(1, notice.getNotice_title());
		query.setInteger(2, notice.getNotice_id());
		session.beginTransaction();
		query.executeUpdate();
		session.getTransaction().commit();
		session.flush();
		session.close();
	}
	public void choose(Notice notice)
	{
		NoticeDAO dao=new NoticeDAO();
		Notice n=dao.findById(notice.getNotice_id());
		if(n==null)
		{
			insert(notice);
		}
		else
		{
			update(notice);
		}
	}
	public int find_number_ByMonth(int month)
	{
		int number;
		NoticeDAO dao=new NoticeDAO();
		number=dao.find_number_Bymonth(month);
		return number;
	}
	public int find_number_ByWeek(int week)
	{
		int number;
		NoticeDAO dao=new NoticeDAO();
		number=dao.find_number_ByWeek(week);
		return number;
	}
	public int find_number_ByDay(int day)
	{
		int number;
		NoticeDAO dao=new NoticeDAO();
		number=dao.find_number_ByDay(day);
		return number;
	}
	public int find_number_All()
	{
		int number;
		NoticeDAO dao=new NoticeDAO();
		number=dao.findAll().size();
		return number;
	}
	public List find_All(int id,int account)
	{
		NoticeDAO dao=new NoticeDAO();
		List list=dao.find_All(id,account);
		return list;
	}
	public Notice finb_ById(int id)
	{
		NoticeDAO dao=new NoticeDAO();
		Notice notice=dao.findById(id);
		return notice;
	}
	public List find_ByMonth(int month,int id,int account)
	{
		NoticeDAO dao=new NoticeDAO();
		List list=dao.find_ByMonth(month, id, account);
		return list;
	}
	public List find_ByWeek(int week,int id,int account)
	{
		NoticeDAO dao=new NoticeDAO();
		List list=dao.find_ByWeek(week, id, account);
		return list;
	}
	public List find_ByDay(int day,int id,int account)
	{
		NoticeDAO dao=new NoticeDAO();
		List list=dao.find_ByDay(day, id, account);
		return list;
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
		
//		Notice notice=new Notice();
//		notice.setNotice_title("PDD");
//		notice.setNotice_html("misaya");
//		insert(notice);

		List list=find_ByDay(30,8,7);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.println(find_number_All());
//	
//		Query  query=session.createQuery("update Notice as m set m.notice_html=? where m.notice_id=?");
//		query.setString(0, "LoveLin");
//		query.setInteger(1, 5);
//		session.beginTransaction();
//		query.executeUpdate();
//		session.getTransaction().commit();
//		session.flush();
//		session.close();
	//	List list=query.list();
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			Notice notice=(Notice)it.next();
			out.println(notice.getNotice_title());
		}
		
//		Iterator it=list.iterator();
//		Date a=new Date();
//		Calendar cal=Calendar.getInstance();
//		cal.setTime(a);
//		out.println(cal.get(Calendar.MONTH));
		
		
		
		
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
