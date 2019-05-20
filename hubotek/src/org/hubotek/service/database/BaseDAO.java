package org.hubotek.service.database;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hubotek.service.DAO;
import org.nanotek.Base;
import org.springframework.stereotype.Service;


@Service
public class BaseDAO <K extends Serializable , T extends Base<K>> implements DAO<T>{

	@PersistenceContext 
	protected EntityManager entityManager;
	
	public T findById(Class<T> clazz , K id )
	{ 
		return entityManager.find(clazz, id);
	}
	
	public T save (T instance)
	{ 
		entityManager.persist(instance);
		return instance;
	}
	
	public T detach(T instance)
	{ 
		entityManager.detach(instance);
		return instance;
	}
	
	public List<T> findByQuery(String query , Class<T> clazz)
	{ 
		return entityManager.createQuery(query, clazz).getResultList();
	}
	
	public void delete(T instance)
	{ 
		entityManager.remove(instance);
	}
	
	public T refresh (T instance)
	{ 
		entityManager.refresh(instance);
		return instance;
	}
}
