package DataSource.Document;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DocumentData {
	private List<Document> dataList;
	// private List<Document> allData;
	private int pageIndex = 1;
	private String search;
	private String select = "    所有";
	private String catalog = "all";
	private static final int EACH_PAGE = 7;
	// private String catalog = "全部";
	private DocumentDAO dao;
	public static final String CATALOG_ALL = "all";
	public static final String CATALOG_DOCUMENT = "document";
	public static final String CATALOG_LIB = "lib";
	public static final String CATALOG_SOURCECODE = "sourceCode";
	public static final String CATALOG_SOFTWARE = "software";
	public static final String CATALOG_DESIGN = "design";

	public DocumentData() {
		this.dao = DocumentDAO.sharedDocumentDAO();
	}

	public String getCatalog(int n) {
		return dataList.get(n).getDocumentCatalog();
	}

	public String getTitle(int n) {
		return dataList.get(n).getDocumentTitle();
	}

	public String getContent(int n) {
		int len = dataList.get(n).getDocumentContent().length();
		len = (len > 50) ? 50 : len;
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

	public String getFile(int n) {
		Document document = dataList.get(n);
		return document.getDocumentFile();
	}

	public void setDataOfPage(int n) {
		setPageIndex(n);
		setDataList();
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public List<Document> getDataList() {
		return dataList;
	}

	private void setDataList() {
		// dataList = dao.find_All(pageNum, EACH_PAGE);
		// System.out.println(this.dataList);
		// System.out.println(dao.findById(1));
		this.dataList = (List<Document>) this.dao.find_All(this.pageIndex,
				DocumentData.EACH_PAGE);
		// System.out.println(this.dataList.get(0).getDocumentTitle());
	}

	public void setDataList(List<Document> list) {
		this.dataList = list;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void setDataWithSearchKeyOfCatalog(String searchKey, String catalog) {
		System.out.println("setDataWithSearchKeyOfCatalog"+ searchKey +" " + catalog);
		if (searchKey.equals("") && catalog.equals("all")) {
			this.setDataList(this.dao.find_All(this.pageIndex, EACH_PAGE));
			// this.dataList = this.dao.find(this.pageIndex,
			// DocumentData.EACH_PAGE,
			// searchKey, catalog);
		} else if (searchKey.equals("")) {
			this.setDataOfCatalog(catalog);
		} else if (catalog.equals("all")) {
			this.setDataWithSearchKey(searchKey);
		} else {
			this.setDataList(this.dao.find(this.pageIndex,EACH_PAGE,searchKey,catalog));
		}
		// System.out.println("set data end");
	}

	public void setDataWithSearchKey(String searchKey) {
		this.setDataList(this.dao.findWithSearchKey(this.pageIndex,
				this.EACH_PAGE, searchKey));
	}

	public void setDataOfCatalog(String catalog) {
		this.setDataList(this.dao.findOfCatalog(this.pageIndex,
				DocumentData.EACH_PAGE, catalog));
	}

	public int getCountOfPage() {
		return (this.dataList.size() - 1) / this.EACH_PAGE + 1;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
}
