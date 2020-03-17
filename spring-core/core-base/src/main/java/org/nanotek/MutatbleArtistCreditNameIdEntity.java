package org.nanotek;

import java.io.Serializable;

public interface MutatbleArtistCreditNameIdEntity<K extends Serializable> extends ArtistCreditNameIdEntity<K> {
	void setArtistCreditNameId(K k);
}
