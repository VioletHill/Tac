package DataSource.Team;

import java.util.Vector;

import DataSource.User.User;


public class Team 
{
	int id;
	String title;
	String content;
	int type;	
	int interestedCount;
	boolean isInterested;
	Vector<User> joinUsers;
	Vector<User> waitUsers;
	User publishUser;
	int month;
	int day;
	int year;
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

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

	public User getPublishUser() {
		return publishUser;
	}

	public void setPublishUser(User publishUser) {
		this.publishUser = publishUser;
	}


}
