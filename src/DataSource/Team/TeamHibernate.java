package DataSource.Team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;

import DataSource.User.User;
import DataSource.User.UserDAO;
import TacHibernateSessionFactory.HibernateSessionFactory;

public class TeamHibernate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	static TeamHibernate _teamHibernate;
	
	synchronized public static TeamHibernate sharedTeamHibernate()
	{
		if (_teamHibernate==null)
		{
			_teamHibernate=new TeamHibernate();
		}
		return _teamHibernate;
	}
	public TeamHibernate() {
		// TODO Auto-generated constructor stub
	}

	public void insert(Team team)
	{
		TeamDAO dao=new TeamDAO();
		Calendar cal = Calendar.getInstance();
		team.setYear(cal.get(Calendar.YEAR));
		team.setMonth(cal.get(Calendar.MONTH) + 1);
		team.setDay(cal.get(Calendar.DAY_OF_MONTH));
		Vector<User> joinuser=team.getJoinUsers();
		Vector<User> waitusers=team.getWaitUsers();
		team.setInterestedCount(0);
		dao.save(team);
		int team_id=team.getId();
		if(joinuser!=null)
		{
			for(int i=0;i<joinuser.size();i++)
			{
				TeamJoinusers teamJoinusers=new TeamJoinusers();
				teamJoinusers.setTeam_id(team_id);
				teamJoinusers.setUser_account(joinuser.elementAt(i).getAccount());
				TeamJoinusersDAO dao2=new TeamJoinusersDAO();
				dao2.save(teamJoinusers);
			}
		}
		if(waitusers!=null)
		{
			for(int i=0;i<waitusers.size();i++)
			{
				TeamWaitusers teamWaitusers=new TeamWaitusers();
				teamWaitusers.setTeam_id(team_id);
				teamWaitusers.setUser_account(waitusers.elementAt(i).getAccount());
				TeamWaitusersDAO dao2=new TeamWaitusersDAO();
				dao2.save(teamWaitusers);
			}
		}
	}
	public void update(Team team)
	{
		TeamDAO dao=new TeamDAO();
		dao.update(team);
	}
	public void choose(Team team)
	{
		TeamDAO dao=new TeamDAO();
		Team t=dao.findById(team.getId());
		if(t==null)
		{
			insert(team);
		}
		else {
			update(team);
		}
	}
	public int interestedcountAdd(int id,String user_account)
	{
		String query_string="from Team as n where n.id=?";
		Session session=HibernateSessionFactory.getSession();
		Query query=session.createQuery(query_string);
		query.setParameter(0, id);
		session.beginTransaction();
		List list=null;
		list=query.list();
		session.getTransaction().commit();
		session.flush();
		session.close();
		if(!IsInterested(id, user_account))
		{
			String query_string2="update Team as n set n.interestedCount=? where n.id=?";
			Session session2=HibernateSessionFactory.getSession();
			Query query2=session2.createQuery(query_string2);
			query2.setParameter(0, ((Team)list.get(0)).getInterestedCount()+1);
			query2.setParameter(1, id);
			session2.beginTransaction();
			query2.executeUpdate();
			session2.getTransaction().commit();
			session2.flush();
			session2.close();
			UserInterested userInterested=new UserInterested();
			userInterested.setTeam_id(id);
			userInterested.setUser_account(user_account);
			userInterested.setType(((Team)list.get(0)).getType());
			UserInterestedDAO dao=new UserInterestedDAO();
			dao.save(userInterested);
			return ((Team)list.get(0)).getInterestedCount()+1;
		}
		else
		{
			return ((Team)list.get(0)).getInterestedCount();
		}

	}
	public int interestedcountSub(int id,String user_account) {
		String query_string="from Team as n where n.id=?";
		String test;
		Session session=HibernateSessionFactory.getSession();
		Query query=session.createQuery(query_string);
		query.setParameter(0, id);
		session.beginTransaction();
		List list=null;
		list=query.list();
		session.getTransaction().commit();
		session.flush();
		session.close();
		if(IsInterested(id, user_account))
		{
			String query_string2="update Team as n set n.interestedCount=? where n.id=?";
			Session session2=HibernateSessionFactory.getSession();
			Query query2=session2.createQuery(query_string2);
			query2.setParameter(0, ((Team)list.get(0)).getInterestedCount()-1);
			query2.setParameter(1, id);
			session2.beginTransaction();
			query2.executeUpdate();
			session2.getTransaction().commit();
			session2.flush();
			session2.close();
			UserInterestedDAO dao=new UserInterestedDAO();
			dao.delete(id, user_account);
			return ((Team)list.get(0)).getInterestedCount()-1;
		}
		else{
			return ((Team)list.get(0)).getInterestedCount();
		}
		
	}
	public boolean delete(int id)
	{
		TeamDAO dao=new TeamDAO();
		TeamJoinusersDAO dao2=new TeamJoinusersDAO();
		TeamWaitusersDAO dao3=new TeamWaitusersDAO();
		UserInterestedDAO dao4=new UserInterestedDAO();
		Team team=dao.findById(id);
		if(team==null)
		{
			return false;
		}
		else {
			dao2.delete(id);
			dao3.delete(id);
			dao4.delete(id);
			dao.delete(id);
			return true;
		}
		
	}
	public void add_join(int id,String account)
	{
		TeamJoinusers joinusers=new TeamJoinusers();
		joinusers.setTeam_id(id);
		joinusers.setUser_account(account);
		TeamJoinusersDAO dao=new TeamJoinusersDAO();
		dao.save(joinusers);
		TeamWaitusersDAO dao2=new TeamWaitusersDAO();
		dao2.delete(id, account);
	}
	public void add_wait(int id,String account)
	{
		TeamWaitusers waitusers=new TeamWaitusers();
		waitusers.setTeam_id(id);
		waitusers.setUser_account(account);
		TeamWaitusersDAO dao=new TeamWaitusersDAO();
		dao.save(waitusers);
	}
	public void delete_wait(int id,String account)
	{
		TeamWaitusersDAO dao=new TeamWaitusersDAO();
		dao.delete(id, account);
	}
	public void delete_join(int id,String account)
	{
		TeamJoinusersDAO dao=new TeamJoinusersDAO();
		dao.delete(id, account);
	}
	public List findByPage(int account,int page)
	{
		TeamDAO dao=new TeamDAO();
		List list=dao.findByPage(account, page);
		UserDAO userDAO=new UserDAO();
		Vector<User> joinUsers=new Vector<User>();
		Vector<User> waitUsers=new Vector<User>();
		List<Team> teams=new ArrayList<Team>();
		if(list!=null)
		{
			for (int i = 0; i < list.size(); i++) {
				Team team=(Team)list.get(i);
				List joinerList=dao.findJoiner(team.getId());
				List waiterList=dao.findWaiter(team.getId());
				if(joinerList!=null)
				{
					for (int j = 0; j <joinerList.size(); j++) {
						String user_account=((TeamJoinusers)joinerList.get(j)).getUser_account();
						User user=userDAO.find_by_account(user_account);
						joinUsers.add(user);
					}
				}
				if(waiterList!=null)
				{
					for (int j = 0; j < waiterList.size(); j++) {
						String user_account=((TeamWaitusers)waiterList.get(j)).getUser_account();
						User user=userDAO.find_by_account(user_account);
						waitUsers.add(user);
					}
				}
				team.setJoinUsers(joinUsers);
				team.setWaitUsers(waitUsers);
				teams.add(team);
 			}
			return teams;
		}
		else {
			return list;
		}

	}
	public int number_findByPage()
	{
		TeamDAO dao=new TeamDAO();
		return dao.number_findByPage();
	}
	
	public List findByType(int type,int account,int page)
	{
		TeamDAO dao=new TeamDAO();
		List list=dao.findByType(account, page, type);
		UserDAO userDAO=new UserDAO();
		Vector<User> joinUsers=new Vector<User>();
		Vector<User> waitUsers=new Vector<User>();
		List<Team> teams=new ArrayList<Team>();
		if(list!=null)
		{
			for (int i = 0; i < list.size(); i++) {
				Team team=(Team)list.get(i);
				List joinerList=dao.findJoiner(team.getId());
				List waiterList=dao.findWaiter(team.getId());
				if(joinerList!=null)
				{
					for (int j = 0; j <joinerList.size(); j++) {
						String user_account=((TeamJoinusers)joinerList.get(j)).getUser_account();
						User user=userDAO.find_by_account(user_account);
						joinUsers.add(user);
					}
				}
				if(waiterList!=null)
				{
					for (int j = 0; j < waiterList.size(); j++) {
						String user_account=((TeamWaitusers)waiterList.get(j)).getUser_account();
						User user=userDAO.find_by_account(user_account);
						waitUsers.add(user);
					}
				}
				team.setJoinUsers(joinUsers);
				team.setWaitUsers(waitUsers);
				teams.add(team);
 			}
			return teams;
		}
		else {
			return list;
		}
	}
	public int number_findByType(int type)
	{
		TeamDAO dao=new TeamDAO();
		return dao.number_findByType(type);
	}
	
	public List findMyType(int type,String user_account,int account,int page) {
		TeamDAO dao=new TeamDAO();
		List list=dao.findMyType(account, page, type, user_account);
		UserDAO userDAO=new UserDAO();
		Vector<User> joinUsers=new Vector<User>();
		Vector<User> waitUsers=new Vector<User>();
		List<Team> teams=new ArrayList<Team>();
		if(list!=null)
		{
			for (int i = 0; i < list.size(); i++) {
				Team team=(Team)list.get(i);
				List joinerList=dao.findJoiner(team.getId());
				List waiterList=dao.findWaiter(team.getId());
				if(joinerList!=null)
				{
					for (int j = 0; j <joinerList.size(); j++) {
						String user_account1=((TeamJoinusers)joinerList.get(j)).getUser_account();
						User user=userDAO.find_by_account(user_account1);
						joinUsers.add(user);
					}
				}
				if(waiterList!=null)
				{
					for (int j = 0; j < waiterList.size(); j++) {
						String user_account1=((TeamWaitusers)waiterList.get(j)).getUser_account();
						User user=userDAO.find_by_account(user_account1);
						waitUsers.add(user);
					}
				}
				team.setJoinUsers(joinUsers);
				team.setWaitUsers(waitUsers);
				teams.add(team);
 			}
			return teams;
		}
		else {
			return list;
		}
	}
	public int number_findMyType(int type,String user_account) {
		TeamDAO dao=new TeamDAO();
		return dao.number_findMyType(type, user_account);
	}
	
	public boolean IsInterested(int id,String user_account)
	{
		UserInterestedDAO dao=new UserInterestedDAO();
		return dao.IsInterested(id, user_account);
	}

	
	public List findInterestedType(int type,String user_account,int account,int page)
	{
		UserInterestedDAO dao1=new UserInterestedDAO();
		List list=dao1.findInterestedType(type, user_account, account, page);
		TeamDAO dao=new TeamDAO();
		UserDAO userDAO=new UserDAO();
		Vector<User> joinUsers=new Vector<User>();
		Vector<User> waitUsers=new Vector<User>();
		List<Team> teams=new ArrayList<Team>();
		if(list!=null)
		{
			for (int i = 0; i < list.size(); i++) {
				Team team=(Team)list.get(i);
				List joinerList=dao.findJoiner(team.getId());
				List waiterList=dao.findWaiter(team.getId());
				if(joinerList!=null)
				{
					for (int j = 0; j <joinerList.size(); j++) {
						String user_account1=((TeamJoinusers)joinerList.get(j)).getUser_account();
						User user=userDAO.find_by_account(user_account1);
						joinUsers.add(user);
					}
				}
				if(waiterList!=null)
				{
					for (int j = 0; j < waiterList.size(); j++) {
						String user_account1=((TeamWaitusers)waiterList.get(j)).getUser_account();
						User user=userDAO.find_by_account(user_account1);
						waitUsers.add(user);
					}
				}
				team.setJoinUsers(joinUsers);
				team.setWaitUsers(waitUsers);
				teams.add(team);
 			}
			return teams;
		}
		else {
			return list;
		}
	}
	public int number_findInterestedType(int type,String user_account)
	{
		UserInterestedDAO dao=new UserInterestedDAO();
		return dao.number_findInterestedType(type, user_account);
	}
	
}
