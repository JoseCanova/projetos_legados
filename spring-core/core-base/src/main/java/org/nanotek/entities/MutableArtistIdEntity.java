package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.ArtistIdEntity;

public interface MutableArtistIdEntity<K extends Serializable> extends ArtistIdEntity<K>{

	void setArtistId(K k);
	
}
