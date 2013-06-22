package DataSource.Team;

import DataSource.User.User;
import TacHibernate.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Team
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see DataSource.Team.Team
 * @author MyEclipse Persistence Tools
 */

public class TeamDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TeamDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String TYPE = "type";
	public static final String INTERESTEDCOUNT = "interestedcount";
	public static final String PUBLISHER_ACCOUNT = "publisherAccount";
	public static final String YEAR = "year";
	public static final String MONTH = "month";
	public static final String DAY = "day";
	public static final String JOIN_HEAD = "joinHead";
	public static final String JOIN_USER = "joinUser";

	public void save(Team transientInstance) {
		log.debug("saving Team instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Team persistentInstance) {
		log.debug("deleting Team instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Team findById(java.lang.Integer id) {
		log.debug("getting Team instance with id: " + id);
		try {
			Team instance = (Team) getSession().get("DataSource.Team.Team", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Team instance) {
		log.debug("finding Team instance by example");
		try {
			List results = getSession().createCriteria("DataSource.Team.Team")
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
		log.debug("finding Team instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Team as model where model."
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

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByInterestedcount(Object interestedcount) {
		return findByProperty(INTERESTEDCOUNT, interestedcount);
	}

	public List findByPublisherAccount(Object publisherAccount) {
		return findByProperty(PUBLISHER_ACCOUNT, publisherAccount);
	}

	public List findByYear(Object year) {
		return findByProperty(YEAR, year);
	}

	public List findByMonth(Object month) {
		return findByProperty(MONTH, month);
	}

	public List findByDay(Object day) {
		return findByProperty(DAY, day);
	}

	public List findByJoinHead(Object joinHead) {
		return findByProperty(JOIN_HEAD, joinHead);
	}

	public List findByJoinUser(Object joinUser) {
		return findByProperty(JOIN_USER, joinUser);
	}

	public List findAll() {
		log.debug("finding all Team instances");
		try {
			String queryString = "from Team";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Team merge(Team detachedInstance) {
		log.debug("merging Team instance");
		try {
			Team result = (Team) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Team instance) {
		log.debug("attaching dirty Team instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Team instance) {
		log.debug("attaching clean Team instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public void update(Team team) {
		String query_string="update Team as n set n.title=?,n.content=?,n.type=? where n.id=?";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, team.getTitle());
		query.setParameter(1, team.getContent());
		query.setParameter(2, team.getType());
		query.setParameter(3, team.getId());
		query.executeUpdate();
		// TODO Auto-generated method stub
	}

	public void delete(int id) {
		String query_string="delete Team as n where n.id=?";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, id);
		query.executeUpdate();
		// TODO Auto-generated method stub
	}
	public void update_join_head(int id,String user_account)
	{
		String query_string="from User as n where n.account=?";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, user_account);
		List list=query.list();
		String join_head=((User)list.get(0)).getHeader_add();
		String query_string2="update Team as n set n.join_head=? where n.id=?";
		Query query2=getSession().createQuery(query_string2);
		query2.setParameter(0, join_head);
		query2.setParameter(1, id);
		query2.executeUpdate();
	}
	public void update_join_user(int id,String user_account)
	{
		String query_string="from TeamJoinusers as n where n.team_id=?";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, id);
		List list=query.list();
		if(list.size()>0)
		{
			String join_user=user_account+"���˼�������Ŀ";
			String query_string2="update Team as n set n.join_user=? where n.id=?";
			Query query2=getSession().createQuery(query_string2);
			query2.setParameter(0, join_user);
			query2.setParameter(1, id);
			query2.executeUpdate();
		}
		else {
			String join_user=user_account+"��������Ŀ";
			String query_string2="update Team as n set n.join_user=? where n.id=?";
			Query query2=getSession().createQuery(query_string2);
			query2.setParameter(0, join_user);
			query2.setParameter(1, id);
			query2.executeUpdate();
		}
	}
	public void delete_join_head(int id,String user_account)
	{
		String query_string="from TeamJoinusers as n where n.team_id=? order by n.id desc";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, id);
		List list=query.list();
		if (list.size()>0) {
			String join_user=((TeamJoinusers)list.get(0)).getUser_account();
			String query_String2="from User as n where n.account=?";
			Query query2=getSession().createQuery(query_String2);
			query2.setParameter(0, join_user);
			String join_head=((User)query2.list().get(0)).getHeader_add();
			String query_string3="update Team as n set n.join_head=? where n.id=?";
			Query query3=getSession().createQuery(query_string3);
			query3.setParameter(0, join_head);
			query3.setParameter(1, id);
			query3.executeUpdate();
		}
		else {
			String join_head=null;
			String query_string2="update Team as n set n.join_head=? where n.id=?";
			Query query2=getSession().createQuery(query_string2);
			query2.setParameter(0, join_head);
			query2.setParameter(1, id);
			query2.executeUpdate();
		}
	}
	public void delete_join_user(int id,String user_account)
	{
		String query_string="from TeamJoinusers as n where n.team_id=? order by n.id desc";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, id);
		List list=query.list();
		if (list.size()>0) {
			String join_user=((TeamJoinusers)list.get(0)).getUser_account();
			if(list.size()>1)
			{
				String join_user_name=join_user+"���˼�������Ŀ";
				String query_string3="update Team as n set n.join_user=? where n.id=?";
				Query query3=getSession().createQuery(query_string3);
				query3.setParameter(0, join_user_name);
				query3.setParameter(1, id);
				query3.executeUpdate();
			}
			else {
				String join_user_name=join_user+"��������Ŀ";
				String query_string3="update Team as n set n.join_user=? where n.id=?";
				Query query3=getSession().createQuery(query_string3);
				query3.setParameter(0, join_user_name);
				query3.setParameter(1, id);
				query3.executeUpdate();
			}
		}
		else {
			String join_user="û���˼�����Ŀ";
			String query_string2="update Team as n set n.join_user=? where n.id=?";
			Query query2=getSession().createQuery(query_string2);
			query2.setParameter(0, join_user);
			query2.setParameter(1, id);
			query2.executeUpdate();
		}
	}
	public List findByPage(int account,int page)
	{
		if(page>0)
		{
			String query_string="from Team as n order by n.id desc";
			Query query=getSession().createQuery(query_string);
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
	public int number_findByPage()
	{
		String query_string="from Team";
		Query query=getSession().createQuery(query_string);
		List list=query.list();
		if(list==null)
		{
			return 0;
		}
		else {
			return list.size();
		}
	}
	public List findByType(int account,int page,int type)
	{
		String query_string="from Team as n where n.type=? order by n.id desc";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, type);
		int number = (page - 1) * account;
		query.setFirstResult(number);
		query.setMaxResults(account);
		return query.list();
	}
	public int number_findByType(int type) {
		String query_string="from Team as n where n.type=?";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, type);
		List list=query.list();
		if(list==null)
		{
			return 0;
		}
		else {
			return list.size();
		}
	}
	public List findMyType(int account,int page,int type,String user_account)
	{
		String query_string="from Team as n where n.type=? and n.publisher_account=? order by n.id desc";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, type);
		query.setParameter(1, user_account);
		int number = (page - 1) * account;
		query.setFirstResult(number);
		query.setMaxResults(account);
		return query.list();
	}
	public int number_findMyType(int type,String user_account) {
		String query_string="from Team as n where n.type=? and n.publisher_account=?";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, type);
		query.setParameter(1, user_account);
		List list=query.list();
		if(list==null)
		{
			return 0;
		}
		else {
			return list.size();
		}
	}
	public List findJoiner(int id)
	{
		String query_string="from TeamJoinusers as n where n.team_id=?";
		Query query=getSession().createQuery(query_string);
		query.setParameter(0, id);
		return query.list();
	}
}