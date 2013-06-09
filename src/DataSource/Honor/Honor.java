package DataSource.Honor;

import java.io.Serializable;

public class Honor implements Serializable {
	private int honor_id;
	private String title;
	private String cover_add;
	private String content;
	private String picture_add;
	private String developer;
	private String date;
	private String[] picture;
	
	public int getHonor_id() {
		return honor_id;
	}
	public void setHonor_id(int honor_id) {
		this.honor_id = honor_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCover_add() {
		return cover_add;
	}
	public void setCover_add(String cover_add) {
		this.cover_add = cover_add;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture_add() {
		return picture_add;
	}
	public void setPicture_add(String picture_add) {
		this.picture_add = picture_add;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String[] getPicture() {
		return picture;
	}
	public void setPicture(String[] picture) {
		this.picture = picture;
	}

	public Honor() {
		// TODO Auto-generated constructor stub
	}

}
