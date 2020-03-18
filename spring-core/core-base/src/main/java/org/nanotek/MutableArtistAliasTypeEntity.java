package org.nanotek;

import java.io.Serializable;

public interface MutableArtistAliasTypeEntity<K extends Serializable> extends ArtistAliasTypeEntity<K> {

	void setArtistAliasType(K k);
	
}
