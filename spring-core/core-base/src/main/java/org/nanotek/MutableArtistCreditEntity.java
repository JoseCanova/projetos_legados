package org.nanotek;

import java.io.Serializable;

public interface MutableArtistCreditEntity<K extends Serializable> extends ArtistCreditEntity<K> {

	void setArtistCredit(K k);
	
}
