package DataSource.Team;

import java.util.Vector;

import DataSource.User.User;
import DataSource.User.UserHibernate;


public class Team 
{
	int id;
	String title;
	String content;
	int type;	
	int interestedCount;
	Vector<User> joinUsers;
	Vector<User> waitUsers;
	User publishUser=null;
	String  publisher_account;
	int month;
	int day;
	int year;
	boolean isInterested;
	
	public User getPublishUser() {
		if (publishUser==null)
		{
			publishUser=UserHibernate.sharedUserHibernate().find_by_account(publisher_account);
		}
		return publishUser;
	}
	public void setPublishUser(User publishUser) 
	{
		publisher_account=publishUser.getAccount();
		this.publishUser = publishUser;
	}


	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vector<User> getJoinUsers() {
		return joinUsers;
	}

	public void setJoinUsers(Vector<User> joinUsers) {
		this.joinUsers = joinUsers;
	}

	public Vector<User> getWaitUsers() {
		return waitUsers;
	}

	public void setWaitUsers(Vector<User> waitUsers) {
		this.waitUsers = waitUsers;
	}
	public String getPublisher_account() {
		return publisher_account;
	}
	public void setPublisher_account(String publisher_account) {
		this.publisher_account = publisher_account;
	}
	public boolean getIsInterested() {
		return isInterested;
	}
	public void setIsInterested(boolean isInterested) {
		this.isInterested = isInterested;
	}




}
