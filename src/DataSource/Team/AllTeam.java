package DataSource.Team;

import java.util.Vector;

import com.sun.org.apache.bcel.internal.generic.NEW;

import DataSource.User.User;
import DataSource.User.UserHibernate;

public class AllTeam  
{
	Vector<Team> allTeams=new Vector<Team>();
	public AllTeam()
	{
		Team newTeam=new Team();
		newTeam.setPublishUser(UserHibernate.sharedUserHibernate().find_by_account("a"));
		newTeam.setTitle("aa");
		newTeam.setContent("asf");
		newTeam.setType(1);
		allTeams.add(newTeam);
	}
	public Vector<Team> getAllTeams() {
		return allTeams;
	}
	public void setAllTeams(Vector<Team> allTeams) {
		this.allTeams = allTeams;
	}
	
	
}
