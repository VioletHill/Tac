package DataSource.Document;

import java.util.Date;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document document = new Document("hello world", 0, new Date(), "");
		DocumentDAO dao = DocumentDAO.sharedDocumentDAO();
		document = dao.findById(1);
		System.out.println(document.getDocumentTitle());
		DocumentData data = new DocumentData();
		//data.setPageNum(Integer.parseInt(request.getParameter("page")));
		data.setDataOfPage(1);
		System.out.println(data.getDataList().get(0).getDocumentTitle());
	}

}
