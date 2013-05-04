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
	
	//number
		public int find_number_ByMonth(int year,int month)
		{
			int number;
			NoticeDAO dao=new NoticeDAO();
			number=dao.find_number_Bymonth(year,month);
			return number;
		}
		public int find_number_ByMonth()
		{
			int number;
			NoticeDAO dao=new NoticeDAO();
			number=dao.find_number_Bymonth();
			return number;
		}
		public int find_number_ByWeek(int year,int week)
		{
			int number;
			NoticeDAO dao=new NoticeDAO();
			number=dao.find_number_ByWeek(year,week);
			return number;
		}
		public int find_number_ByWeek()
		{
			int number;
			NoticeDAO dao=new NoticeDAO();
			number=dao.find_number_ByWeek();
			return number;
		}
		public int find_number_ByDay(int year,int month,int day)
		{
			int number;
			NoticeDAO dao=new NoticeDAO();
			number=dao.find_number_ByDay(year,month,day);
			return number;
		}
		public int find_number_ByDay()
		{
			int number;
			NoticeDAO dao=new NoticeDAO();
			number=dao.find_number_ByDay();
			return number;
		}
		public int find_number_All()
		{
			int number;
			NoticeDAO dao=new NoticeDAO();
			number=dao.findAll().size();
			return number;
		}
		public int search_number(String key)
		{
			int number;
			NoticeDAO dao=new NoticeDAO();
			number=dao.search_number(key);
			return number;
		}
		public int search_number_ByMonth(String key,int year,int month)
		{
			int number;
			NoticeDAO dao=new NoticeDAO();
			number=dao.search_number_ByMonth(key,year, month);
			return number;
		}
		public int search_number_ByMonth(String key)
		{
			int number;
			NoticeDAO dao=new NoticeDAO();
			number=dao.search_number_ByMonth(key);
			return number;
		}
		public int search_number_ByWeek(String key,int year,int week)
		{
			int number;
			NoticeDAO dao=new NoticeDAO();
			number=dao.search_number_ByWeek(key,year, week);
			return number;
		}
		public int search_number_ByWeek(String key)
		{
			int number;
			NoticeDAO dao=new NoticeDAO();
			number=dao.search_number_ByWeek(key);
			return number;
		}
		public int search_number_ByDay(String key,int year,int month,int day)
		{
			int number;
			NoticeDAO dao=new NoticeDAO();
			number=dao.search_number_ByDay(key, year,month,day);
			return number;
		}
		public int search_number_ByDay(String key)
		{
			int number;
			NoticeDAO dao=new NoticeDAO();
			number=dao.search_number_ByDay(key);
			return number;
		}
		
		//find
		public List find_All(int page,int account)
		{
			NoticeDAO dao=new NoticeDAO();
			List list=dao.find_All(page,account);
			return list;
		}
		public List find_ByMonth(int year,int month,int page,int account)
		{
			NoticeDAO dao=new NoticeDAO();
			List list=dao.find_ByMonth(year,month, page, account);
			return list;
		}
		public List find_ByMonth(int page,int account)
		{
			NoticeDAO dao=new NoticeDAO();
			List list=dao.find_ByMonth( page, account);
			return list;
		}
		public List find_ByWeek(int year,int week,int page,int account)
		{
			NoticeDAO dao=new NoticeDAO();
			List list=dao.find_ByWeek(year,week, page, account);
			return list;
		}
		public List find_ByWeek(int page,int account)
		{
			NoticeDAO dao=new NoticeDAO();
			List list=dao.find_ByWeek( page, account);
			return list;
		}
		public List find_ByDay(int year,int month,int day,int page,int account)
		{
			NoticeDAO dao=new NoticeDAO();
			List list=dao.find_ByDay(year,month,day, page, account);
			return list;
		}
		public List find_ByDay(int page,int account)
		{
			NoticeDAO dao=new NoticeDAO();
			List list=dao.find_ByDay(page, account);
			return list;
		}
		public List search(String key,int page,int account)
		{
			NoticeDAO dao=new NoticeDAO();
			List list=dao.search(key,page,account);
			return list;
		}
		public List search_ByMonth(String key,int year,int month,int page,int account)
		{
			NoticeDAO dao=new NoticeDAO();
			List list=dao.search_ByMonth(key, year,month, page, account);
			return list;
		}
		public List search_ByMonth(String key,int page,int account)
		{
			NoticeDAO dao=new NoticeDAO();
			List list=dao.search_ByMonth(key, page, account);
			return list;
		}
		public List search_ByWeek(String key,int year,int week,int page,int account)
		{
			NoticeDAO dao=new NoticeDAO();
			List list=dao.search_ByWeek(key, year,week, page, account);
			return list;
		}
		public List search_ByWeek(String key,int page,int account)
		{
			NoticeDAO dao=new NoticeDAO();
			List list=dao.search_ByWeek(key, page, account);
			return list;
		}
		public List search_ByDay(String key,int year,int month,int day,int page,int account)
		{
			NoticeDAO dao=new NoticeDAO();
			List list=dao.search_ByDay(key, year,month,day, page, account);
			return list;
		}
		public List search_ByDay(String key,int page,int account)
		{
			NoticeDAO dao=new NoticeDAO();
			List list=dao.search_ByDay(key,  page, account);
			return list;
		}
		//find html
		public Notice finb_ById(int id)
		{
			NoticeDAO dao=new NoticeDAO();
			Notice notice=dao.findById(id);
			
			return notice;
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
