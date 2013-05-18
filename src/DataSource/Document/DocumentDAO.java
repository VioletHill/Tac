package DataSource.Document;

// default package

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
 * @see .Document
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

	// 데절
	private static DocumentDAO documentDAO = null;

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
			Document instance = (Document) getSession().get("Document", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Document instance) {
		log.debug("finding Document instance by example");
		try {
			List results = getSession().createCriteria("Document")
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

	// 데절
	synchronized static public DocumentDAO sharedDocumentDAO() {
		if (documentDAO == null) {
			documentDAO = new DocumentDAO();
		}
		return documentDAO;
	}
}