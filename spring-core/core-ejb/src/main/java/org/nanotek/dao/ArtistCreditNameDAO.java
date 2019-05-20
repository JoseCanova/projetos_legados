package org.nanotek.dao;

import javax.ejb.Local;

import org.nanotek.beans.ArtistCreditName;

@Local
public interface ArtistCreditNameDAO  extends DAO<ArtistCreditName>{

	ArtistCreditName findArtistCreditByMbid(Long mbid);
	
}
