package DataSource.Notices;

import java.util.Calendar;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import TacHibernate.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Notice entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see DataSource.Notices.Notice
 * @author MyEclipse Persistence Tools
 */

public class NoticeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(NoticeDAO.class);
	// property constants
	public static final String NOTICE_TITLE = "notice_title";
	public static final String NOTICE_HTML = "notice_html";
	public static final String NOTICE_YEAR = "notice_year";
	public static final String NOTICE_MONTH = "notice_month";
	public static final String NOTICE_WEEK = "notice_week";
	public static final String NOTICE_DAY = "notice_day";

	public void save(Notice transientInstance) {
		log.debug("saving Notice instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Notice persistentInstance) {
		log.debug("deleting Notice instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public void delete(int id) {
		String query_string = "delete Notice as n where n.notice_id=?";
		Query query = getSession().createQuery(query_string);
		query.setParameter(0, id);
		query.executeUpdate();
	}

	public int search_number(String key) {
		log.debug("getting Notice instance with id: " + key);
		try {
			String query_string = "from Notice as n where n.notice_title like '%"
					+ key + "%'";
			Query query = getSession().createQuery(query_string);
			List list = query.list();
			return list.size();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public int search_number_ByMonth(String key, int year, int month) {
		log.debug("getting Notice instance with id: " + key);
		try {
			String query_string = "from Notice as n where n.notice_year=? and n.notice_month=? and n.notice_title like '%"
					+ key + "%'";
			Query query = getSession().createQuery(query_string);
			query.setParameter(0, year);
			query.setParameter(1, month);
			List list = query.list();
			return list.size();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public int search_number_ByMonth(String key) {
		log.debug("getting Notice instance with id: " + key);
		try {
			String query_string = "from Notice as n where n.notice_year=? and n.notice_month=? and n.notice_title like '%"
					+ key + "%'";
			Query query = getSession().createQuery(query_string);
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			query.setParameter(0, year);
			query.setParameter(1, month);
			List list = query.list();
			return list.size();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public int search_number_ByWeek(String key, int year, int week) {
		log.debug("getting Notice instance with id: " + key);
		try {
			String query_string = "from Notice as n where n.notice_year=? and n.notice_week=? and n.notice_title like '%"
					+ key + "%'";
			Query query = getSession().createQuery(query_string);
			query.setParameter(0, year);
			query.setParameter(1, week);
			List list = query.list();
			return list.size();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public int search_number_ByWeek(String key) {
		log.debug("getting Notice instance with id: " + key);
		try {
			String query_string = "from Notice as n where n.notice_year=? and n.notice_week=? and n.notice_title like '%"
					+ key + "%'";
			Query query = getSession().createQuery(query_string);
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int week = cal.get(Calendar.WEEK_OF_YEAR);
			query.setParameter(0, year);
			query.setParameter(1, week);
			List list = query.list();
			return list.size();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public int search_number_ByDay(String key, int year, int month, int day) {
		log.debug("getting Notice instance with id: " + key);
		try {
			String query_string = "from Notice as n where n.notice_year=? and n.notice_month=? and n.notice_day=? and n.notice_title like '%"
					+ key + "%'";
			Query query = getSession().createQuery(query_string);
			query.setParameter(0, year);
			query.setParameter(1, month);
			query.setParameter(2, day);
			List list = query.list();
			return list.size();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public int search_number_ByDay(String key) {
		log.debug("getting Notice instance with id: " + key);
		try {
			String query_string = "from Notice as n where n.notice_year=? and n.notice_month=? and n.notice_day=? and n.notice_title like '%"
					+ key + "%'";
			Query query = getSession().createQuery(query_string);
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			query.setParameter(0, year);
			query.setParameter(1, month);
			query.setParameter(2, day);
			List list = query.list();
			return list.size();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Notice findById(int id) {
		log.debug("getting Notice instance with id: " + id);
		try {
			String query_string = "from Notice as n where n.notice_id=?";
			Query query = getSession().createQuery(query_string);
			query.setParameter(0, id);
			List list = query.list();
			if (list.isEmpty())
				return null;
			else
				return (Notice) list.get(0);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public int find_number_Bymonth(int year, int month) {
		log.debug("getting Notice instance with id: " + month);
		try {
			String query_string = "from Notice as n where n.notice_year=? and n.notice_month=?";
			Query query = getSession().createQuery(query_string);
			query.setParameter(0, year);
			query.setParameter(1, month);
			List list = query.list();
			return list.size();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public int find_number_Bymonth() {
		log.debug("getting Notice instance with id: ");
		try {
			String query_string = "from Notice as n where n.notice_year=? and n.notice_month=?";
			Query query = getSession().createQuery(query_string);
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			query.setParameter(0, year);
			query.setParameter(1, month);
			List list = query.list();
			return list.size();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public int find_number_ByWeek(int year, int week) {
		log.debug("getting Notice instance with id: " + week);
		try {
			String query_string = "from Notice as n where n.notice_year=? and n.notice_week=?";
			Query query = getSession().createQuery(query_string);
			query.setParameter(0, year);
			query.setParameter(1, week);
			List list = query.list();
			return list.size();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public int find_number_ByWeek() {
		log.debug("getting Notice instance with id: ");
		try {
			String query_string = "from Notice as n where n.notice_year=? and n.notice_week=?";
			Query query = getSession().createQuery(query_string);
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int week = cal.get(Calendar.WEEK_OF_YEAR);
			query.setParameter(0, year);
			query.setParameter(1, week);
			List list = query.list();
			return list.size();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public int find_number_ByDay(int year, int month, int day) {
		log.debug("getting Notice instance with id: " + day);
		try {
			String query_string = "from Notice as n where n.notice_year=? and n.notice_month=? and n.notice_day=?";
			Query query = getSession().createQuery(query_string);
			query.setParameter(0, year);
			query.setParameter(1, month);
			query.setParameter(2, day);
			List list = query.list();
			return list.size();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public int find_number_ByDay() {
		log.debug("getting Notice instance with id: ");
		try {
			String query_string = "from Notice as n where n.notice_year=? and n.notice_month=? and n.notice_day=?";
			Query query = getSession().createQuery(query_string);
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			query.setParameter(0, year);
			query.setParameter(1, month);
			query.setParameter(2, day);
			List list = query.list();
			return list.size();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List find_All(int page, int account) {
		log.debug("finding all Notice instances");
		try {
			if (page > 0) {
				String query_string = "select new Notice(notice_id,notice_title,notice_year,notice_month,notice_day) from Notice as n order by n.notice_id desc";
				Query query = getSession().createQuery(query_string);
				int number = (page - 1) * account;
				query.setFirstResult(number);
				query.setMaxResults(account);
				return query.list();
			} else {
				List list = null;
				return list;
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List find_ByMonth(int year, int month, int page, int account) {
		log.debug("finding all Notice instances");
		try {
			if (page > 0) {
				String query_string = "select new Notice(notice_id,notice_title,notice_year,notice_month,notice_day) from Notice as n where n.notice_year=? and n.notice_month=? order by n.notice_id desc";
				Query query = getSession().createQuery(query_string);
				int number = (page - 1) * account;
				query.setParameter(0, year);
				query.setParameter(1, month);
				query.setFirstResult(number);
				query.setMaxResults(account);
				return query.list();
			} else {
				List list = null;
				return list;
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List find_ByMonth(int page, int account) {
		log.debug("finding all Notice instances");
		try {
			if (page > 0) {
				String query_string = "select new Notice(notice_id,notice_title,notice_year,notice_month,notice_day) from Notice as n where n.notice_year=? and n.notice_month=? order by n.notice_id desc";
				Query query = getSession().createQuery(query_string);
				int number = (page - 1) * account;
				Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH) + 1;
				query.setParameter(0, year);
				query.setParameter(1, month);
				query.setFirstResult(number);
				query.setMaxResults(account);
				return query.list();
			} else {
				List list = null;
				return list;
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List find_ByDay(int year, int month, int day, int page, int account) {
		log.debug("finding all Notice instances");
		try {
			if (page > 0) {
				String query_string = "select new Notice(notice_id,notice_title,notice_year,notice_month,notice_day) from Notice as n where n.notice_year=? and n.notice_month=? and n.notice_day=? order by n.notice_id desc";
				Query query = getSession().createQuery(query_string);
				query.setParameter(0, year);
				query.setParameter(1, month);
				query.setParameter(2, day);
				int number = (page - 1) * account;
				query.setFirstResult(number);
				query.setMaxResults(account);
				return query.list();
			} else {
				List list = null;
				return list;
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List find_ByDay(int page, int account) {
		log.debug("finding all Notice instances");
		try {
			if (page > 0) {
				String query_string = "select new Notice(notice_id,notice_title,notice_year,notice_month,notice_day) from Notice as n where n.notice_year=? and n.notice_month=? and n.notice_day=? order by n.notice_id desc";
				Query query = getSession().createQuery(query_string);
				Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH) + 1;
				int day = cal.get(Calendar.DAY_OF_MONTH);
				query.setParameter(0, year);
				query.setParameter(1, month);
				query.setParameter(2, day);
				int number = (page - 1) * account;
				query.setFirstResult(number);
				query.setMaxResults(account);
				return query.list();
			} else {
				List list = null;
				return list;
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List find_ByWeek(int year, int week, int page, int account) {
		log.debug("finding all Notice instances");
		try {
			if (page > 0) {
				String query_string = "select new Notice(notice_id,notice_title,notice_year,notice_month,notice_day) from Notice as n where n.notice_year=? and n.notice_week=? order by n.notice_id desc";
				Query query = getSession().createQuery(query_string);
				query.setParameter(0, year);
				query.setParameter(1, week);
				int number = (page - 1) * account;
				query.setFirstResult(number);
				query.setMaxResults(account);
				return query.list();
			} else {
				List list = null;
				return list;
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List find_ByWeek(int page, int account) {
		log.debug("finding all Notice instances");
		try {
			if (page > 0) {
				String query_string = "select new Notice(notice_id,notice_title,notice_year,notice_month,notice_day) from Notice as n where n.notice_year=? and n.notice_week=? order by n.notice_id desc";
				Query query = getSession().createQuery(query_string);
				Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				int week = cal.get(Calendar.WEEK_OF_YEAR);
				query.setParameter(0, year);
				query.setParameter(1, week);
				int number = (page - 1) * account;
				query.setFirstResult(number);
				query.setMaxResults(account);
				return query.list();
			} else {
				List list = null;
				return list;
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List search(String key, int page, int account) {
		log.debug("finding Notice instance by example");
		try {
			String query_string = "select new Notice(notice_id,notice_title,notice_year,notice_month,notice_day) from Notice as n where n.notice_title like '%"
					+ key + "%' order by n.notice_id desc";
			Query query = getSession().createQuery(query_string);
			int number = (page - 1) * account;
			query.setFirstResult(number);
			query.setMaxResults(account);
			return query.list();
		} catch (RuntimeException re) {
			log.error("search failed", re);
			throw re;
		}
	}

	public List search_ByMonth(String key, int year, int month, int page,
			int account) {
		log.debug("finding Notice instance by example");
		try {
			String query_string = "select new Notice(notice_id,notice_title,notice_year,notice_month,notice_day) from Notice as n where n.notice_year=? and n.notice_month=? and n.notice_title like '%"
					+ key + "%' order by n.notice_id desc";
			Query query = getSession().createQuery(query_string);
			int number = (page - 1) * account;
			query.setParameter(0, year);
			query.setParameter(1, month);
			query.setFirstResult(number);
			query.setMaxResults(account);
			return query.list();
		} catch (RuntimeException re) {
			log.error("search failed", re);
			throw re;
		}
	}

	public List search_ByMonth(String key, int page, int account) {
		log.debug("finding Notice instance by example");
		try {
			String query_string = "select new Notice(notice_id,notice_title,notice_year,notice_month,notice_day) from Notice as n where n.notice_year=? and n.notice_month=? and n.notice_title like '%"
					+ key + "%' order by n.notice_id desc";
			Query query = getSession().createQuery(query_string);
			int number = (page - 1) * account;
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			query.setParameter(0, year);
			query.setParameter(1, month);
			query.setFirstResult(number);
			query.setMaxResults(account);
			return query.list();
		} catch (RuntimeException re) {
			log.error("search failed", re);
			throw re;
		}
	}

	public List search_ByWeek(String key, int year, int week, int page,
			int account) {
		log.debug("finding Notice instance by example");
		try {
			String query_string = "select new Notice(notice_id,notice_title,notice_year,notice_month,notice_day) from Notice as n where n.notice_year=? and n.notice_week=? and n.notice_title like '%"
					+ key + "%' order by n.notice_id desc";
			Query query = getSession().createQuery(query_string);
			int number = (page - 1) * account;
			query.setParameter(0, year);
			query.setParameter(1, week);
			query.setFirstResult(number);
			query.setMaxResults(account);
			return query.list();
		} catch (RuntimeException re) {
			log.error("search failed", re);
			throw re;
		}
	}

	public List search_ByWeek(String key, int page, int account) {
		log.debug("finding Notice instance by example");
		try {
			String query_string = "select new Notice(notice_id,notice_title,notice_year,notice_month,notice_day) from Notice as n where n.notice_year=? and n.notice_week=? and n.notice_title like '%"
					+ key + "%' order by n.notice_id desc";
			Query query = getSession().createQuery(query_string);
			int number = (page - 1) * account;
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int week = cal.get(Calendar.WEEK_OF_YEAR);
			query.setParameter(0, year);
			query.setParameter(1, week);
			query.setFirstResult(number);
			query.setMaxResults(account);
			return query.list();
		} catch (RuntimeException re) {
			log.error("search failed", re);
			throw re;
		}
	}

	public List search_ByDay(String key, int year, int month, int day,
			int page, int account) {
		log.debug("finding Notice instance by example");
		try {
			String query_string = "select new Notice(notice_id,notice_title,notice_year,notice_month,notice_day) from Notice as n where n.notice_year=? and n.notice_month=? and n.notice_day=? and n.notice_title like '%"
					+ key + "%' order by n.notice_id desc";
			Query query = getSession().createQuery(query_string);
			int number = (page - 1) * account;
			query.setParameter(0, year);
			query.setParameter(1, month);
			query.setParameter(2, day);
			query.setFirstResult(number);
			query.setMaxResults(account);
			return query.list();
		} catch (RuntimeException re) {
			log.error("search failed", re);
			throw re;
		}
	}

	public List search_ByDay(String key, int page, int account) {
		log.debug("finding Notice instance by example");
		try {
			String query_string = "select new Notice(notice_id,notice_title,notice_year,notice_month,notice_day) from Notice as n where n.notice_year=? and n.notice_month=? and n.notice_day=? and n.notice_title like '%"
					+ key + "%' order by n.notice_id desc";
			Query query = getSession().createQuery(query_string);
			int number = (page - 1) * account;
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			query.setParameter(0, year);
			query.setParameter(1, month);
			query.setParameter(2, day);
			query.setFirstResult(number);
			query.setMaxResults(account);
			return query.list();
		} catch (RuntimeException re) {
			log.error("search failed", re);
			throw re;
		}
	}

	public List findByExample(Notice instance) {
		log.debug("finding Notice instance by example");
		try {
			List results = getSession()
					.createCriteria("DataSource.Notices.Notice")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Notice instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Notice as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNotice_title(Object notice_title) {
		return findByProperty(NOTICE_TITLE, notice_title);
	}

	public List findByNotice_html(Object notice_html) {
		return findByProperty(NOTICE_HTML, notice_html);
	}

	public List findByNotice_year(Object notice_year) {
		return findByProperty(NOTICE_YEAR, notice_year);
	}

	public List findByNotice_month(Object notice_month) {
		return findByProperty(NOTICE_MONTH, notice_month);
	}

	public List findByNotice_week(Object notice_week) {
		return findByProperty(NOTICE_WEEK, notice_week);
	}

	public List findByNotice_day(Object notice_day) {
		return findByProperty(NOTICE_DAY, notice_day);
	}

	public List findAll() {
		log.debug("finding all Notice instances");
		try {
			String queryString = "from Notice";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Notice merge(Notice detachedInstance) {
		log.debug("merging Notice instance");
		try {
			Notice result = (Notice) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Notice instance) {
		log.debug("attaching dirty Notice instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Notice instance) {
		log.debug("attaching clean Notice instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}