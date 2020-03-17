package org.nanotek;

import java.io.Serializable;

public interface MutableArtistEntity<K extends Serializable> extends ArtistEntity<K>{
   
	void setArtist(K e);
	
	
}
