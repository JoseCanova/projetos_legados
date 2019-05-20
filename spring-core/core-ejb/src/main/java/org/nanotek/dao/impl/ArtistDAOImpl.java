package org.nanotek.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.ArtistName;
import org.nanotek.dao.ArtistDAO;

@Stateless(name="ArtistDAO" , mappedName="ArtistDAO")
@SuppressWarnings({"serial","unchecked"})
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ArtistDAOImpl extends LocalBaseDAO<ArtistName> implements ArtistDAO {

	public ArtistName find(Long id) 
	{ 
		return find(ArtistName.class, id);
	}
	
	public ArtistName getReference (Long id)
	{ 
		return getReference(ArtistName.class , id);
	}
	
	@Override
	public List<ArtistName> loadAll() {
		return em.createNamedQuery("ArtistLoadAll").getResultList();
	}

	@Override
	public List<ArtistName> listRecords(Integer firstResult, Integer maxResults) {
		return em.createNamedQuery("ArtistLoadAll").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Set<ArtistCredit> findArtistCredits(Long artistId) {
		return em.find(ArtistName.class, artistId).getArtistCredits();
	}

	@Override
	public List<?> findByName(String value) {
		String hql = "Select a from ArtistName a where a.name like ?";
		return  em.createQuery(hql, ArtistName.class).setParameter(0, value).getResultList();
	}

	@Override
	public List<?> findByName(String value, boolean normalize) {
		String param = null;
		String hql =  "Select a from ArtistName a where ";
		if (normalize) {
			hql = hql + " upper(a.name) like :param ";
			param = "%" + value.toUpperCase() + "%";
		}else { 
			hql =  hql + " a.name like  :param ";	
			param = value;
		}
		Query query = em.createQuery(hql, ArtistName.class);
		query.setParameter("param", param);
		return query.getResultList();
	}

	@Override
	public  <T extends Serializable> ArtistName find(T id) {
		return  em.find(ArtistName.class , id);
	}
	
}
