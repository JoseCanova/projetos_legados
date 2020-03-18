package org.nanotek;

import java.io.Serializable;

public interface MutableArtistEndDateEntity<K extends Serializable> extends ArtistEndDateEntity<K>{

	void setArtistEndDate(K k);
	
}
