package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.ArtistEntity;

public interface MutableArtistEntity<K extends Serializable> extends ArtistEntity<K>{
   
	void setArtist(K e);
	
	
}
