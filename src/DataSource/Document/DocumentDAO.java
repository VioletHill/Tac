package DataSource.Document;

import TacHibernate.BaseHibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Document entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see DataSource.Document.Document
 * @author MyEclipse Persistence Tools
 */

public class DocumentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DocumentDAO.class);

	// property constants
	public static final String DOCUMENT_TITLE = "documentTitle";
	public static final String DOCUMENT_CONTENT = "documentContent";
	public static final String DOCUMENT_FILE = "documentFile";
	public static final String DOCUMENT_DOWNLOAD_COUNT = "documentDownloadCount";
	public static final String DOCUMENT_CATALOG = "documentCatalog";

	//singleton
	public static DocumentDAO documentDAO = null;

	public void save(Document transientInstance) {
		log.debug("saving Document instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Document persistentInstance) {
		log.debug("deleting Document instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Document findById(java.lang.Integer id) {
		log.debug("getting Document instance with id: " + id);
		try {
			Document instance = (Document) getSession().get(
					"DataSource.Document.Document", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Document instance) {
		log.debug("finding Document instance by example");
		try {
			List results = getSession()
					.createCriteria("DataSource.Document.Document")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Document instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Document as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDocumentTitle(Object documentTitle) {
		return findByProperty(DOCUMENT_TITLE, documentTitle);
	}

	public List findByDocumentContent(Object documentContent) {
		return findByProperty(DOCUMENT_CONTENT, documentContent);
	}

	public List findByDocumentFile(Object documentFile) {
		return findByProperty(DOCUMENT_FILE, documentFile);
	}

	public List findByDocumentDownloadCount(Object documentDownloadCount) {
		return findByProperty(DOCUMENT_DOWNLOAD_COUNT, documentDownloadCount);
	}

	public List findByDocumentCatalog(Object documentCatalog) {
		return findByProperty(DOCUMENT_CATALOG, documentCatalog);
	}

	public List findAll() {
		log.debug("finding all Document instances");
		try {
			String queryString = "from Document";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Document merge(Document detachedInstance) {
		log.debug("merging Document instance");
		try {
			Document result = (Document) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Document instance) {
		log.debug("attaching dirty Document instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Document instance) {
		log.debug("attaching clean Document instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	// Mark
	public List find_All(int page, int eachPage) {
		log.debug("finding all Notice instances");
		try {
			if (page > 0) {
				String query_string = "select new Document(documentId,documentTitle,documentContent,documentFile,documentDownloadCount,documentTimestamp,documentCatalog) from Document as d order by d.documentId desc";
				Query query = getSession().createQuery(query_string);
				int number = (page - 1) * eachPage;
				query.setFirstResult(number);
				query.setMaxResults(eachPage);
				return query.list();
			} else {
				List list = null;
				return list;
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public static DocumentDAO sharedDocumentDAO() {
		// TODO Auto-generated method stub
		if (documentDAO == null) {
			documentDAO = new DocumentDAO();
		}
		return documentDAO;
	}
	
	
	/*
	 * 以下为获得条目个数的函数
	 */
	public int getCountWithSearchKey(String key) {
		log.debug("getting count of Document instance with search key: " + key);
		try {
			String query_string = "select count(*) from Document as d where d.documentTitle like '%"
					+ key + "%'";
			Query query = getSession().createQuery(query_string);
//			List list = query.list();
			return  ((Integer) query.iterate().next()).intValue();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public int getCountOfCatalog(String catalog) {
		log.debug("getting count of Document instance of Catalog: " + catalog);
		try {
			String query_string = "select count(*) from Document as d where d.documentCatalog="
					+ catalog;
			Query query = getSession().createQuery(query_string);
//			List list = query.list();
			return  ((Integer) query.iterate().next()).intValue();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public int getCountOfCatalogWithSearch(String catalog, String searchKey) {
		log.debug("getting count of Document instance of catalog with search key: " + catalog);
		try {
			String query_string = "select count(*) from Document as d where d.documentCatalog="
					+ catalog + "and d.documentTitle like '%" + searchKey + "%'";
			Query query = getSession().createQuery(query_string);
//			List list = query.list();
			return  ((Integer) query.iterate().next()).intValue();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	/*
	 * 以下为带条件的问询
	 * 类别
	 * 搜索关键词
	 */
	public List find(int page, int eachPage, String searchKey, String catalog) {
		log.debug("finding all Document instances");
		try {
			if (page > 0) {
				String query_string = "select new Document(documentId,documentTitle,documentContent,documentFile,documentDownloadCount,documentTimestamp,documentCatalog) " +
						"from Document as d where d.documentCatalog = '" + catalog +
						"' and d.documentTitle like '%" +
						searchKey + "%'" + "order by d.documentId desc "
						;
//				String query_string = "select new Document(documentId,documentTitle,documentContent,documentFile,documentDownloadCount,documentTimestamp,documentCatalog) " +
//						"from Document as d order by d.documentId desc " +
//						"where d.documentCatalog=lib and d.documentTitle like '%测试%'";
				Query query = getSession().createQuery(query_string);
				int number = (page - 1) * eachPage;
				query.setFirstResult(number);
				query.setMaxResults(eachPage);
				return query.list();
			} else {
				List list = null;
				return list;
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findWithSearchKey(int page, int eachPage, String searchKey) {
		log.debug("finding all Notice instances");
		try {
			if (page > 0) {
				String query_string = "select new Document(documentId,documentTitle,documentContent,documentFile,documentDownloadCount,documentTimestamp,documentCatalog) " +
						"from Document as d where d.documentTitle like '%" +
						searchKey + "%'" + " order by d.documentId desc "
						;
				Query query = getSession().createQuery(query_string);
				int number = (page - 1) * eachPage;
				query.setFirstResult(number);
				query.setMaxResults(eachPage);
				return query.list();
			} else {
				List list = null;
				return list;
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findOfCatalog(int page, int eachPage, String catalog) {
		log.debug("finding all Notice instances");
		try {
			if (page > 0) {
				String query_string = "select new Document(documentId,documentTitle,documentContent,documentFile,documentDownloadCount,documentTimestamp,documentCatalog) " +
						"from Document as d where d.documentCatalog = '" + catalog +
						"' order by d.documentId desc "
						;
				Query query = getSession().createQuery(query_string);
				int number = (page - 1) * eachPage;
				query.setFirstResult(number);
				query.setMaxResults(eachPage);
				return query.list();
			} else {
				List list = null;
				return list;
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}