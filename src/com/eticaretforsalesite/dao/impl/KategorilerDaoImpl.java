package com.eticaretforsalesite.dao.impl;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eticaretforsalesite.dao.KategorilerDao;
import com.eticaretforsalesite.model.Kategoriler;
import com.eticaretforsalesite.util.HibernateUtil;

public class KategorilerDaoImpl implements KategorilerDao {
	private static Logger logger = LoggerFactory.getLogger(KategorilerDaoImpl.class);

	public void saveKategori(Kategoriler kategori) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.save(kategori);
		logger.info("Database kayıt işlemi başarıyla gerçekleşti. -->" + kategori);
		session.getTransaction().commit();
		session.close();
	}

}
