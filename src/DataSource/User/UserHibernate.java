package DataSource.User;

import java.io.Serializable;

public class UserHibernate implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static UserHibernate _userHibernate;
	
	synchronized public static UserHibernate sharedUserHibernate()
	{
		if (_userHibernate==null)
		{
			_userHibernate=new UserHibernate();
		}
		return _userHibernate;
	}
	
	public void insert(User user)
	{
		UserDAO dao=new UserDAO();
		user.setPermission(0);
		dao.save(user);
	}
	public boolean judge(String account)
	{
		UserDAO dao=new UserDAO();
		if(dao.judge(account))
		{
			return false;
		}
		else {
			return true;
		}
	}
	public boolean judge_login(String account,String password)
	{
		UserDAO dao=new UserDAO();
		if(dao.judge_login(account, password))
		{
			return true;
		}
		else {
			return false;
		}
	}
	public User find_by_account(String account)
	{
		User user=new User();
		UserDAO dao=new UserDAO();
		return dao.find_by_account(account);
	}
	public UserHibernate() {
		// TODO Auto-generated constructor stub
	}

}
