package org.nanotek.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class EntityManagerFactoryProducer {

	  @Produces
	  @ApplicationScoped
	  public EntityManagerFactory createEntityManagerFactory() {
	    return Persistence.createEntityManagerFactory("spring-core-music-brainz");
	  }

	  public void close(@Disposes EntityManagerFactory entityManagerFactory) {
	    entityManagerFactory.close();
	  }

	  @Produces
	  @RequestScoped
	  public EntityManager createEntityManager(EntityManagerFactory entityManagerFactory) {
	    return entityManagerFactory.createEntityManager();
	  }

	  public void close(@Disposes EntityManager entityManager) {
	    entityManager.close();
	  }
	}
