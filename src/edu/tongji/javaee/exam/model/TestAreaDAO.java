package edu.tongji.javaee.exam.model;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TestArea entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.tongji.javaee.exam.model.TestArea
 * @author MyEclipse Persistence Tools
 */

public class TestAreaDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TestAreaDAO.class);
	// property constants
	public static final String TEST_AREA = "testArea";
	public static final String DESCRIPTION = "description";
	public static final String IMAGE_FILE = "imageFile";

	public void save(TestArea transientInstance) {
		log.debug("saving TestArea instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TestArea persistentInstance) {
		log.debug("deleting TestArea instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TestArea findById(java.lang.Integer id) {
		log.debug("getting TestArea instance with id: " + id);
		try {
			TestArea instance = (TestArea) getSession().get(
					"edu.tongji.javaee.exam.model.TestArea", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TestArea instance) {
		log.debug("finding TestArea instance by example");
		try {
			List results = getSession()
					.createCriteria("edu.tongji.javaee.exam.model.TestArea")
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
		log.debug("finding TestArea instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TestArea as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTestArea(Object testArea) {
		return findByProperty(TEST_AREA, testArea);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByImageFile(Object imageFile) {
		return findByProperty(IMAGE_FILE, imageFile);
	}

	public List findAll() {
		log.debug("finding all TestArea instances");
		try {
			String queryString = "from TestArea";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TestArea merge(TestArea detachedInstance) {
		log.debug("merging TestArea instance");
		try {
			TestArea result = (TestArea) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TestArea instance) {
		log.debug("attaching dirty TestArea instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TestArea instance) {
		log.debug("attaching clean TestArea instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}