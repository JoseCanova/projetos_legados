package org.nanotek.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.dao.ArtistCreditDAO;

@SuppressWarnings({"serial","unchecked"})
@Stateless(name="ArtistCreditDAO" , mappedName="ArtistCreditDAO")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ArtistCreditDAOImpl  extends LocalBaseDAO<ArtistCredit>  implements ArtistCreditDAO {

	public List<ArtistCredit> findArtistCreditsByArtistId(Long artistId)
	{ 
		return em.createNamedQuery("FindArtistCreditsByArtistId", ArtistCredit.class).setParameter("artistId" , artistId).getResultList();
	}
	
	@Override
	public ArtistCredit findArtistCreditByArtistCreditId(Long artistCreditId) {
		return (ArtistCredit) em.createNamedQuery("FindArtistCreditById").setParameter("artistCreditId", artistCreditId).getSingleResult();
	}
	
	public List<ArtistCredit> findArtistCredits(List<Long> credits)
	{ 
		return em.createNamedQuery("FindArtistCredits").setParameter("ids", credits).getResultList();
	}

	@Override
	public List<ArtistCredit> loadAll() {
		return em.createNamedQuery("ArtistCreditLoadAll").getResultList();
	}

	@Override
	public List<ArtistCredit> listRecords(Integer firstResult,
			Integer maxResults) {
		return em.createNamedQuery("ArtistCreditLoadAll").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}
	
	public ArtistCredit find (Long id) 
	{ 
		return find (ArtistCredit.class, id);
	}

	@Override
	public  <T extends Serializable> ArtistCredit find(T id) {
		return em.find(ArtistCredit.class , id);
	}

}
