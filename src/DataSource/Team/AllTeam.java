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
		newTeam.setPublishUser(UserHibernate.sharedUserHibernate().find_by_account("Hill"));
		newTeam.setTitle("aa");
		newTeam.setContent("asf");
		newTeam.setType(1);
		newTeam.setDay(5);
		newTeam.setMonth(4);
		allTeams.add(newTeam);

		allTeams.add(newTeam);
		
		Team newTeam2=new Team();
		newTeam2.setPublishUser(UserHibernate.sharedUserHibernate().find_by_account("Hill"));
		newTeam2.setTitle("aa");
		newTeam2.setContent("asf");
		newTeam2.setType(1);
		newTeam2.setDay(5);
		newTeam2.setMonth(3);
		allTeams.add(newTeam2);
	}
	public Vector<Team> getAllTeams() {
		return allTeams;
	}
	public void setAllTeams(Vector<Team> allTeams) {
		this.allTeams = allTeams;
	}
	
	
}
