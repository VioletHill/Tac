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
 * TeamJoinusers entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see DataSource.Team.TeamJoinusers
 * @author MyEclipse Persistence Tools
 */

public class TeamJoinusersDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TeamJoinusersDAO.class);
	// property constants
	public static final String TEAM_ID = "team_id";
	public static final String USER_ACCOUNT = "user_account";

	public void save(TeamJoinusers transientInstance) {
		log.debug("saving TeamJoinusers instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TeamJoinusers persistentInstance) {
		log.debug("deleting TeamJoinusers instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TeamJoinusers findById(java.lang.Integer id) {
		log.debug("getting TeamJoinusers instance with id: " + id);
		try {
			TeamJoinusers instance = (TeamJoinusers) getSession().get(
					"DataSource.Team.TeamJoinusers", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TeamJoinusers instance) {
		log.debug("finding TeamJoinusers instance by example");
		try {
			List results = getSession()
					.createCriteria("DataSource.Team.TeamJoinusers")
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
		log.debug("finding TeamJoinusers instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TeamJoinusers as model where model."
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
		log.debug("finding all TeamJoinusers instances");
		try {
			String queryString = "from TeamJoinusers";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TeamJoinusers merge(TeamJoinusers detachedInstance) {
		log.debug("merging TeamJoinusers instance");
		try {
			TeamJoinusers result = (TeamJoinusers) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TeamJoinusers instance) {
		log.debug("attaching dirty TeamJoinusers instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TeamJoinusers instance) {
		log.debug("attaching clean TeamJoinusers instance");
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
		String query_string="delete TeamJoinusers as n where n.team_id=? and n.user_account=?";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, id);
		query.setParameter(1, account);
		query.executeUpdate();
	}
	public void delete(int id)
	{
		String query_string="delete TeamJoinusers as n where n.team_id=?";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, id);
		query.executeUpdate();
	}

}