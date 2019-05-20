package org.nanotek.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.nanotek.Base;

@SuppressWarnings("unchecked")
public abstract class LocalBaseDAO<T extends Base<?>> {

	@PersistenceContext
	protected EntityManager em; 
	
	public abstract List<T> loadAll() ;

	public void persist(T object) {
		em.persist(object);
	}

	public T find(T objectSample) {
		return  (T) em.find(objectSample.getClass(), objectSample.getId());
	}
	
	public <I extends Serializable> T find(Class<T> clazz , I id) {
		return  em.find(clazz, id);
	}
	
	public T getReference (Class<T> clazz , Serializable id)
	{ 
		return em.getReference(clazz, id);
	}
	
	public void update(T object) {
		em.merge(object);
	}

	public void delete(T object) {
		em.remove(object);
	}

	public abstract List<T> listRecords(Integer firstResult, Integer maxResults);
	
}
