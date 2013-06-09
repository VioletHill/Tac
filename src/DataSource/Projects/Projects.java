package DataSource.Projects;

import java.util.Vector;

public class Projects 
{
	String title=null;
	String description=null;
	String appString=null;
	String time;
	String teamMember;

	Vector<String> image=null;
	
	private int indexImg=0;
	
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	public String getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(String teamMember) {
		this.teamMember = teamMember;
	}

	public Projects()
	{
		image=new Vector<String>();
	}

	public String getAppString() {
		return appString;
	}

	public void setAppString(String appString) {
		this.appString = appString;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Vector<String> getImage() {
		return image;
	}

	public void setImage(Vector<String> image) {
		this.image = image;
	}
	public String getNextString()
	{
		return image.get(++indexImg);
	}
	public void setIndexImg2Zero()
	{
		indexImg=0;
	}

}
