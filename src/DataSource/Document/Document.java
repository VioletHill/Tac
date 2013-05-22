package DataSource.Document;

// default package

import java.util.Date;

/**
 * Document entity. @author MyEclipse Persistence Tools
 */
public class Document extends AbstractDocument implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Document() {
	}

	/** minimal constructor */
	public Document(String documentTitle) {
		super(documentTitle);
	}

	/** java thought minimal, but not for DB */
	public Document(String documentTitle, Integer documentDownloadCount,
			Date documentTimestamp, String documentCatalog) {
		super(documentTitle, documentDownloadCount, documentTimestamp, documentCatalog);
	}

	/** full constructor */
	public Document(String documentTitle, String documentContent,
			String documentFile, Integer documentDownloadCount,
			Date documentTimestamp,String documentCatalog) {
		super(documentTitle, documentContent, documentFile,
				documentDownloadCount, documentTimestamp, documentCatalog);
	}

	public Document(Integer documentId, String documentTitle,
			String documentContent, String documentFile,
			Integer documentDownloadCount, Date documentTimestamp, String documentCatalog) {
		super(documentId, documentTitle, documentContent, documentFile,
				documentDownloadCount, documentTimestamp, documentCatalog);
	}
}
