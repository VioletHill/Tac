package DataSource.Notices;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import TacHibernateSessionFactory.HibernateSessionFactory;

public class NoticesHibernate implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static NoticesHibernate noticesHibernate=null;

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
	
	//find_number
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
	
	//find
	public List find_All(int id,int account)
	{
		NoticeDAO dao=new NoticeDAO();
		List list=dao.find_All(id,account);
		return list;
	}
	public Notice find_ById(int id)
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
	
	//search
	public List search(String key,int id,int account)
	{
		NoticeDAO dao=new NoticeDAO();
		List list=dao.search(key,id,account);
		return list;
	}
	public List search_ByMonth(String key,int month,int page,int account)
	{
		NoticeDAO dao=new NoticeDAO();
		List list=dao.search_ByMonth(key, month, page, account);
		return list;
	}
	public List search_ByWeek(String key,int week,int page,int account)
	{
		NoticeDAO dao=new NoticeDAO();
		List list=dao.search_ByWeek(key, week, page, account);
		return list;
	}
	public List search_ByDay(String key,int day,int page,int account)
	{
		NoticeDAO dao=new NoticeDAO();
		List list=dao.search_ByDay(key, day, page, account);
		return list;
	}
	
	//search number
	public int search_number(String key)
	{
		int number;
		NoticeDAO dao=new NoticeDAO();
		number=dao.search_number(key);
		return number;
	}
	public int search_number_ByMonth(String key,int month)
	{
		int number;
		NoticeDAO dao=new NoticeDAO();
		number=dao.search_number_ByMonth(key, month);
		return number;
	}
	public int search_number_ByWeek(String key,int week)
	{
		int number;
		NoticeDAO dao=new NoticeDAO();
		number=dao.search_number_ByWeek(key, week);
		return number;
	}
	public int search_number_ByDay(String key,int day)
	{
		int number;
		NoticeDAO dao=new NoticeDAO();
		number=dao.search_number_ByDay(key, day);
		return number;
	}
	public NoticesHibernate()
	{
		
	}
	
	synchronized static public NoticesHibernate sharedNoticesHibernate()
	{
		if (noticesHibernate==null)
		{
			noticesHibernate=new NoticesHibernate();
		}
		return noticesHibernate;
	}
}
