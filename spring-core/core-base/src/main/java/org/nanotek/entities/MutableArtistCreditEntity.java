package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.ArtistCreditEntity;

public interface MutableArtistCreditEntity<K extends Serializable> extends ArtistCreditEntity<K> {

	void setArtistCredit(K k);
	
}
