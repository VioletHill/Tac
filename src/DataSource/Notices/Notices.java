package DataSource.Notices;

public class Notices 
{
	private String title;
	private String content;
	private String data;
	
	public Notices()
	{
		title="";
		content="";
		data="";
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
}
