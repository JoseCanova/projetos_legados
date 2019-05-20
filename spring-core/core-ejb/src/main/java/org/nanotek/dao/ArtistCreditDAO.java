package org.nanotek.dao;

import java.util.List;

import javax.ejb.Local;

import org.nanotek.beans.ArtistCredit;

@Local
public interface ArtistCreditDAO extends DAO<ArtistCredit> {

	List<ArtistCredit> findArtistCreditsByArtistId(Long artistId); 
	
	ArtistCredit findArtistCreditByArtistCreditId(Long artistCreditId);
	
	List<ArtistCredit> findArtistCredits(List<Long> credits);
	
}
