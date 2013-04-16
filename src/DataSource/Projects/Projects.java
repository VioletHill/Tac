package DataSource.Projects;

import java.util.Vector;

public class Projects 
{
	String title=null;
	String description=null;
	Vector<String> image=null;
	Vector<String> teamMember;
	private int indexImg=0;
	
	public Projects()
	{
		image=new Vector<String>();
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

	public Vector<String> getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(Vector<String> teamMember) {
		this.teamMember = teamMember;
	}
}
