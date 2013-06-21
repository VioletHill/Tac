package DataSource.Team;

import TacHibernate.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TeamWaitusers entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see DataSource.Team.TeamWaitusers
 * @author MyEclipse Persistence Tools
 */

public class TeamWaitusersDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TeamWaitusersDAO.class);
	// property constants
	public static final String TEAM_ID = "team_id";
	public static final String USER_ACCOUNT = "user_account";

	public void save(TeamWaitusers transientInstance) {
		log.debug("saving TeamWaitusers instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TeamWaitusers persistentInstance) {
		log.debug("deleting TeamWaitusers instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TeamWaitusers findById(java.lang.Integer id) {
		log.debug("getting TeamWaitusers instance with id: " + id);
		try {
			TeamWaitusers instance = (TeamWaitusers) getSession().get(
					"DataSource.Team.TeamWaitusers", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TeamWaitusers instance) {
		log.debug("finding TeamWaitusers instance by example");
		try {
			List results = getSession()
					.createCriteria("DataSource.Team.TeamWaitusers")
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
		log.debug("finding TeamWaitusers instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TeamWaitusers as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTeam_id(Object team_id) {
		return findByProperty(TEAM_ID, team_id);
	}

	public List findByUser_account(Object user_account) {
		return findByProperty(USER_ACCOUNT, user_account);
	}

	public List findAll() {
		log.debug("finding all TeamWaitusers instances");
		try {
			String queryString = "from TeamWaitusers";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TeamWaitusers merge(TeamWaitusers detachedInstance) {
		log.debug("merging TeamWaitusers instance");
		try {
			TeamWaitusers result = (TeamWaitusers) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TeamWaitusers instance) {
		log.debug("attaching dirty TeamWaitusers instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TeamWaitusers instance) {
		log.debug("attaching clean TeamWaitusers instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public void delete(int id,String account)
	{
		String query_string="delete TeamWaitusers as n where n.team_id=? and n.user_account=?";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, id);
		query.setParameter(1, account);
		query.executeUpdate();
	}
	public void delete(int id)
	{
		String query_string="delete TeamWaitusers as n where n.team_id=?";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, id);
		query.executeUpdate();
	}
	public boolean IsWait(int id,String user_account)
	{
		String query_string="from TeamWaitusers as n where n.team_id=? and n.user_account=?";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, id);
		query.setParameter(1, user_account);
		List list=query.list();
		if(list.size()>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}