package org.nanotek;

import java.io.Serializable;

public interface ArtistCreditRefCountEntity<K extends Serializable> {

	K getArtistCreditRefCount(K k);
	
}
