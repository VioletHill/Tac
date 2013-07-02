package DataSource.Team;

import java.util.List;

public class AllTeam  
{
	List<Team> allTeams;
	private	int pageIndex;
	private int allPage;
	private int type;
	private int peopleType;
	
	public int getPeopleType() {
		return peopleType;
	}

	public void setPeopleType(int peopleType) {
		this.peopleType = peopleType;
	}

	public AllTeam()
	{
	}
	
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getAllPage() {
		return allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Team> getAllTeams() {
		return allTeams;
	}
	public void setAllTeams(List<Team> allTeams) {
		this.allTeams = allTeams;
	}
	
}
