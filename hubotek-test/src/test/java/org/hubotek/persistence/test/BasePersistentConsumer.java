package org.hubotek.persistence.test;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hubotek.BaseConsumer;
import org.nanotek.Base;

@Named(value="basePersistentConsumer")
public class BasePersistentConsumer implements BaseConsumer {
	
	@PersistenceContext
    protected EntityManager entityManager;
    
	@Override
	public void accept(Base<?> t) {
		try {
			persistBase(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void persistBase(Base<?> base) {
		entityManager.persist(base);
	}
}
