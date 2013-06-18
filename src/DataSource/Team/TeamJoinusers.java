package DataSource.Team;

import java.io.Serializable;

public class TeamJoinusers implements Serializable {
	private int id;
	private int team_id;
	private String user_account;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public TeamJoinusers() {
		// TODO Auto-generated constructor stub
	}

}
