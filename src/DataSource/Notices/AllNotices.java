package DataSource.Notices;

import java.util.List;




public class AllNotices 
{
	List<Notice> list;
	private int totAllNotices;
	private String noticeTime;
	private	int pageIndex;
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

	public int getTotAllNotices() {
		return totAllNotices;
	}

	public void setTotAllNotices(int totAllNotices) {
		this.totAllNotices = totAllNotices;
	}
	
	public AllNotices()
	{
		noticeTime="È«²¿";
		pageIndex=0;
	}
	
}
