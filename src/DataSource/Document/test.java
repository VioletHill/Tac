package DataSource.Document;

import java.util.Date;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document document = new Document("hello world",0,new Date());
		DocumentDAO.sharedDocumentDAO().save(document);
	}

}
