package DataSource.Team;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import TacHibernate.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserInterested entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see DataSource.Team.UserInterested
 * @author MyEclipse Persistence Tools
 */

public class UserInterestedDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserInterestedDAO.class);
	// property constants
	public static final String USER_ACCOUNT = "userAccount";
	public static final String TEAM_ID = "teamId";
	public static final String TYPE = "type";

	public void save(UserInterested transientInstance) {
		log.debug("saving UserInterested instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserInterested persistentInstance) {
		log.debug("deleting UserInterested instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserInterested findById(java.lang.Integer id) {
		log.debug("getting UserInterested instance with id: " + id);
		try {
			UserInterested instance = (UserInterested) getSession().get(
					"DataSource.Team.UserInterested", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserInterested instance) {
		log.debug("finding UserInterested instance by example");
		try {
			List results = getSession()
					.createCriteria("DataSource.Team.UserInterested")
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
		log.debug("finding UserInterested instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UserInterested as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserAccount(Object userAccount) {
		return findByProperty(USER_ACCOUNT, userAccount);
	}

	public List findByTeamId(Object teamId) {
		return findByProperty(TEAM_ID, teamId);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findAll() {
		log.debug("finding all UserInterested instances");
		try {
			String queryString = "from UserInterested";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserInterested merge(UserInterested detachedInstance) {
		log.debug("merging UserInterested instance");
		try {
			UserInterested result = (UserInterested) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserInterested instance) {
		log.debug("attaching dirty UserInterested instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserInterested instance) {
		log.debug("attaching clean UserInterested instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public List<Team> findInterestedType(int type,String user_account,int account,int page) {
		List<Team> team_list = new ArrayList<Team>(); 
		
		String query_string="from UserInterested as n where n.user_account=? and n.type=?";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, user_account);
		query.setParameter(1, type);
		int number = (page - 1) * account;
		query.setFirstResult(number);
		query.setMaxResults(account);
		List list=query.list();
		if(list==null)
		{
			return list;
		}
		else {
			for(int i=0;i<list.size();i++)
			{
				int id=((UserInterested)list.get(i)).getTeam_id();
				String query_string2="from Team as n where n.id=?";
				Query query2=getSession().createQuery(query_string2);
				query2.setParameter(0, id);
				Team aaaTeam=((Team)query2.list().get(0));				
				team_list.add(aaaTeam);
			}
			return team_list;
		}
	}
	public int number_findInterestedType(int type,String user_account) {
		List<Team> team_list = new ArrayList<Team>(); 
		
		String query_string="from UserInterested as n where n.user_account=? and n.type=?";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, user_account);
		query.setParameter(1, type);
		List list=query.list();
		if(list==null)
		{
			return 0;
		}
		else {
			for(int i=0;i<list.size();i++)
			{
				int id=((UserInterested)list.get(i)).getTeam_id();
				String query_string2="from Team as n where n.id=?";
				Query query2=getSession().createQuery(query_string2);
				query2.setParameter(0, id);
				Team aaaTeam=((Team)query2.list().get(0));				
				team_list.add(aaaTeam);
			}
			return team_list.size();
		}
	}
}