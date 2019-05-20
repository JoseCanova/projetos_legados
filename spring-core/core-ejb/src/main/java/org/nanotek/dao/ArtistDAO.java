package org.nanotek.dao;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.ArtistName;

@Local
public interface ArtistDAO extends DAO<ArtistName> {
	
	Set<ArtistCredit> findArtistCredits(Long artistId);
	List<?> findByName(String value) ;
	List<?> findByName(String value, boolean normalize);

}
