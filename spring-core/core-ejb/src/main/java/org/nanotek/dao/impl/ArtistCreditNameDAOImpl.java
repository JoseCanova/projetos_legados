package org.nanotek.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.nanotek.beans.ArtistCreditName;
import org.nanotek.dao.ArtistCreditNameDAO;

@SuppressWarnings("serial")
@Stateless(name="ArtistCreditNameDAO" , mappedName="ArtistCreditNameDAO")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ArtistCreditNameDAOImpl<T extends ArtistCreditName> extends LocalBaseDAO<ArtistCreditName> implements ArtistCreditNameDAO {

	public ArtistCreditName find(Long id) 
	{ 
		return find(ArtistCreditName.class , id );
	}
	
	@Override
	public ArtistCreditName findArtistCreditByMbid(Long mbid) {
		return em.createNamedQuery("FindArtistCreditByMbid",ArtistCreditName.class).setParameter("mbid", mbid).getSingleResult();
	}

	@Override
	public List<ArtistCreditName> loadAll() {
		return em.createQuery("select a from ArtistCreditName a ", ArtistCreditName.class).getResultList();
	}

	@Override
	public List<ArtistCreditName> listRecords(Integer firstResult,
			Integer maxResults) {
		return em.createQuery("select a from ArtistCreditName a ", ArtistCreditName.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}

	@Override
	public <I extends Serializable> ArtistCreditName find(I i) {
		return em.find(ArtistCreditName.class, i);
	}

}
