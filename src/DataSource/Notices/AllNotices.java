package DataSource.Notices;

import java.util.List;

public class AllNotices 
{
	List<Notice> list;
	private int allPage;
	private String noticeTime;
	private	int pageIndex;
	private String search;
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public List<Notice> getAllNotices() {
		return list;
	}

	public void setList(List<Notice> list) {
		this.list = list;
	}

	public String getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(String notieceTime) {
		this.noticeTime = notieceTime;
	}

	
	public int getAllPage() {
		return allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public AllNotices()
	{
		noticeTime="È«²¿";
		pageIndex=0;
	}
	
}
