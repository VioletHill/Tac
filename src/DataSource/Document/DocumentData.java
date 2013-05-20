package DataSource.Document;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DocumentData {
	private List<Document> dataList;
	private int pageNum = 1;
	private static final int EACH_PAGE = 7;
	private String catalog = "全部";
	private DocumentDAO dao;

	public DocumentData() {
		this.dao = new DocumentDAO();
	}

	public String getTitle(int n) {
		return dataList.get(n).getDocumentTitle();
	}

	public String getContent(int n) {
		int len = dataList.get(n).getDocumentContent().length();
		len = (len > 100) ? 100 : len;
		return dataList.get(n).getDocumentContent().substring(0, len) + "...";
	}

	public String getDate(int n) {
		Calendar cal = Calendar.getInstance();
		Document doc = dataList.get(n);
		Date date = doc.getDocumentTimestamp();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return month + "月" + day + "日";
	}

	public void setDataOfPage(int n) {
		setPageNum(n);
		setDataList();
	}

	public List<Document> getDataList() {
		return dataList;
	}

	private void setDataList() {
		// dataList = dao.find_All(pageNum, EACH_PAGE);
		// System.out.println(this.dataList);
		// System.out.println(dao.findById(1));
		this.dataList = this.dao.find_All(this.pageNum, this.EACH_PAGE);
		// System.out.println(this.dataList.get(0).getDocumentTitle());
	}

	public void setDataList(List<Document> list) {
		this.dataList = list;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

}
