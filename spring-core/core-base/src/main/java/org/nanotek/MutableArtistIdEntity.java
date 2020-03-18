package org.nanotek;

import java.io.Serializable;

public interface MutableArtistIdEntity<K extends Serializable> extends ArtistIdEntity<K>{

	void setArtistId(K k);
	
}
