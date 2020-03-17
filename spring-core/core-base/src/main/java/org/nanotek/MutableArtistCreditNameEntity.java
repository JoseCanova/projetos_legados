package org.nanotek;

import java.io.Serializable;

public interface MutableArtistCreditNameEntity<K extends Serializable> extends ArtistCreditNameEntity<K> {

	void setArtistCreditName(K k);
	
}
