package DataSource.Document;

import java.util.Date;

/**
 * AbstractDocument entity provides the base persistence definition of the
 * Document entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractDocument implements java.io.Serializable {

	// Fields

	private Integer documentId;
	private String documentTitle;
	private String documentContent;
	private String documentFile;
	private Integer documentDownloadCount;
	private Date documentTimestamp;
	private String documentCatalog;

	// Constructors

	/** default constructor */
	public AbstractDocument() {
	}

	/** self define minimal */
	public AbstractDocument(String documentTitle) {
		this.documentTitle = documentTitle;
		this.documentDownloadCount = 0;
		this.documentTimestamp = new Date();
	}

	/** minimal constructor */
	public AbstractDocument(String documentTitle,
			Integer documentDownloadCount, Date documentTimestamp,
			String documentCatalog) {
		this.documentTitle = documentTitle;
		this.documentDownloadCount = documentDownloadCount;
		this.documentTimestamp = documentTimestamp;
		this.documentCatalog = documentCatalog;
	}

	/** full constructor */
	public AbstractDocument(String documentTitle, String documentContent,
			String documentFile, Integer documentDownloadCount,
			Date documentTimestamp, String documentCatalog) {
		this.documentTitle = documentTitle;
		this.documentContent = documentContent;
		this.documentFile = documentFile;
		this.documentDownloadCount = documentDownloadCount;
		this.documentTimestamp = documentTimestamp;
		this.documentCatalog = documentCatalog;
	}
	
	public AbstractDocument(Integer documentId, String documentTitle, String documentContent,
			String documentFile, Integer documentDownloadCount,
			Date documentTimestamp, String documentCatalog) {
		this.documentId = documentId;
		this.documentTitle = documentTitle;
		this.documentContent = documentContent;
		this.documentFile = documentFile;
		this.documentDownloadCount = documentDownloadCount;
		this.documentTimestamp = documentTimestamp;
		this.documentCatalog = documentCatalog;
	}

	// Property accessors

	public Integer getDocumentId() {
		return this.documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public String getDocumentTitle() {
		return this.documentTitle;
	}

	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
	}

	public String getDocumentContent() {
		return this.documentContent;
	}

	public void setDocumentContent(String documentContent) {
		this.documentContent = documentContent;
	}

	public String getDocumentFile() {
		return this.documentFile;
	}

	public void setDocumentFile(String documentFile) {
		this.documentFile = documentFile;
	}

	public Integer getDocumentDownloadCount() {
		return this.documentDownloadCount;
	}

	public void setDocumentDownloadCount(Integer documentDownloadCount) {
		this.documentDownloadCount = documentDownloadCount;
	}

	public Date getDocumentTimestamp() {
		return this.documentTimestamp;
	}

	public void setDocumentTimestamp(Date documentTimestamp) {
		this.documentTimestamp = documentTimestamp;
	}

	public String getDocumentCatalog() {
		return this.documentCatalog;
	}

	public void setDocumentCatalog(String documentCatalog) {
		this.documentCatalog = documentCatalog;
	}

}