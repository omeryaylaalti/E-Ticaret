package com.eticaretforsalesite.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eticaretforsalesite.dao.HibernateDao;
import com.eticaretforsalesite.util.HibernateUtil;

public class HibernateDaoImpl implements HibernateDao {
	private static Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

	@Override
	public <T> T select(Class<T> clazz, int id) {
		Session session = openSession();

		try {
			return (T) session.get(clazz, id);
		} finally {
			session.close();
		}
	}

	@Override
	public void save(Object entity) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.save(entity);
			logger.info("Database kayıt işlemi başarıyla tamamlandı!");
			transaction.commit();
		} catch (Exception ex) {
			logger.error("Exception while persisting:" + ex.getMessage());
			transaction.rollback();
		} finally {
			session.close();
		}

	}

	@Override
	public void update(Object entity) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.update(entity);
			transaction.commit();
			logger.info("Update işlemi başarıyla yapıldı.");
		} catch (Exception ex) {
			logger.error("Exception while updating:" + ex.getMessage());
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(Object entity) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.delete(entity);
			transaction.commit();
			logger.info("Databaseden istenilen veri silindi.");
		} catch (Exception ex) {
			logger.error("Exception while deleting:" + ex.getMessage());
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	public <T> List<T> getAllEntities(Class<T> clazz) {
		Session session = openSession();
		Criteria criteria = session.createCriteria(clazz);

		try {
			return criteria.list();
		} finally {
			session.close();
		}
	}

	private Session openSession() {
		Session session = HibernateUtil.openSession();
		return session;
	}

	@Override
	public <T> List<T> getByNamedQuery(String namedQuery, T entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
