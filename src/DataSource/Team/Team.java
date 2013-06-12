package DataSource.Team;

import java.util.Vector;

import DataSource.User.User;


public class Team 
{
	String title;
	String content;
	int type;	
	int interestedCount;
	boolean isInterested;
	Vector<User> joinTeam;
	User publishUser;
	
	public Team()
	{
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getInterestedCount() {
		return interestedCount;
	}
	public void setInterestedCount(int interestedCount) {
		this.interestedCount = interestedCount;
	}
	public boolean isInterested() {
		return isInterested;
	}
	public void setInterested(boolean isInterested) {
		this.isInterested = isInterested;
	}
	public Vector<User> getJoinTeam() {
		return joinTeam;
	}
	public User getPublishUser() {
		return publishUser;
	}

	public void setPublishUser(User publishUser) {
		this.publishUser = publishUser;
	}

	public void setJoinTeam(Vector<User> joinTeam) {
		this.joinTeam = joinTeam;
	}
	
}
