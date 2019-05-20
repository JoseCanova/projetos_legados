package org.hubotek.test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.nanotek.Base;

public class BaseModelPersistenceTestClass extends BaseModelDeployer{

	@PersistenceContext
    protected EntityManager entityManager;
    
    @Inject
    protected UserTransaction utx;
    
    protected void beginTransaction() throws Exception
	{ 
		utx.begin();  
		entityManager.joinTransaction(); 
	}
	
	protected void commitTransaction() throws Exception
	{ 
		utx.commit();
	}
	
	protected void persistBase(Base<?> base) {
		entityManager.persist(base);
	}
	
}
