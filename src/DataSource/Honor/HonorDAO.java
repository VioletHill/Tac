package DataSource.Honor;

import TacHibernate.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Honor
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see DataSource.Honor.Honor
 * @author MyEclipse Persistence Tools
 */

public class HonorDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(HonorDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String COVER_ADD = "cover_add";
	public static final String CONTENT = "content";
	public static final String PICTURE_ADD = "picture_add";
	public static final String DEVELOPER = "developer";
	public static final String DATE = "date";

	public void save(Honor transientInstance) {
		log.debug("saving Honor instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Honor persistentInstance) {
		log.debug("deleting Honor instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public void delete(int id)
	{
		String query_string="delete Honor as n where n.honor_id=?";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, id);
		query.executeUpdate();
	}
	public int find(int id)
	{
		String query_string = "from Honor as n where n.honor_id=? ";
		Query query = getSession().createQuery(query_string);
		query.setParameter(0, id);
		List list = query.list();
		return list.size();
	}
	public void update(Honor honor)
	{
		String query_string="update Honor as n set n.title=?,n.cover_add=?,n.content=?,n.picture_add=?,n.developer=?,n.date=? where n.honor_id=?";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, honor.getTitle());
		query.setParameter(1, honor.getCover_add());
		query.setParameter(2, honor.getContent());
		query.setParameter(3, honor.getPicture_add());
		query.setParameter(4, honor.getDeveloper());
		query.setParameter(5, honor.getDate());
		query.setParameter(6, honor.getHonor_id());
		query.executeUpdate();
	}

	public Honor findById(java.lang.Integer id) {
		log.debug("getting Honor instance with id: " + id);
		try {
			Honor instance = (Honor) getSession().get("DataSource.Honor.Honor",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public int find_number()
	{
		String query_string="from Honor";
		Query query=getSession().createQuery(query_string);
		List list=query.list();
		return list.size();
	}
	public List FindHonorByPage(int account,int page)
	{
		if(page>0)
		{
			String query_string = "from Honor as n order by n.honor_id desc";
			Query query = getSession().createQuery(query_string);
			int number = (page - 1) * account;
			query.setFirstResult(number);
			query.setMaxResults(account);
			return query.list();
		}
		else {
			List list=null;
			return list;
		}
	}

	public List findByExample(Honor instance) {
		log.debug("finding Honor instance by example");
		try {
			List results = getSession()
					.createCriteria("DataSource.Honor.Honor")
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
		log.debug("finding Honor instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Honor as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByCover_add(Object cover_add) {
		return findByProperty(COVER_ADD, cover_add);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByPicture_add(Object picture_add) {
		return findByProperty(PICTURE_ADD, picture_add);
	}

	public List findByDeveloper(Object developer) {
		return findByProperty(DEVELOPER, developer);
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findAll() {
		log.debug("finding all Honor instances");
		try {
			String queryString = "from Honor";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Honor merge(Honor detachedInstance) {
		log.debug("merging Honor instance");
		try {
			Honor result = (Honor) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Honor instance) {
		log.debug("attaching dirty Honor instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Honor instance) {
		log.debug("attaching clean Honor instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}