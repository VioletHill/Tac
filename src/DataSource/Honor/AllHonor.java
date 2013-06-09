package DataSource.Honor;

import java.util.List;
import DataSource.Notices.Notice;

public class AllHonor 
{
	private int page;
	private int allPage;
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getAllPage() {
		return allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public List<Honor> getList() {
		return list;
	}

	public void setList(List<Honor> list) {
		this.list = list;
	}

	private List<Honor> list;
	
	public AllHonor()
	{
		
	}
}
