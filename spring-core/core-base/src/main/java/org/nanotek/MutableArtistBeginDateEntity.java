package org.nanotek;

import java.io.Serializable;

public interface MutableArtistBeginDateEntity<K extends Serializable> extends ArtistBeginDateEntity<K>{

	void setArtistBeginDate(K k);
	
}
