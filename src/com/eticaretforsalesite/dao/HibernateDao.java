package com.eticaretforsalesite.dao;

import java.util.List;

public interface HibernateDao {

	public <T> T select(Class<T> clazz, int id);

	public void save(Object entity);

	public void update(Object entity);

	public void delete(Object entity);

	public <T> List<T> getAllEntities(Class<T> clazz);

	public <T> List<T> getByNamedQuery(String namedQuery, T entity);

}
