package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.ArtistCreditNameEntity;

public interface MutableArtistCreditNameEntity<K extends Serializable> extends ArtistCreditNameEntity<K> {

	void setArtistCreditName(K k);
	
}
