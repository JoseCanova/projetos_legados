package org.nanotek;

import java.io.Serializable;

public interface MutableArtistAliasEntity<K extends Serializable> extends ArtistAliasEntity<K>{

	void setArtistAlias(K k);
	
}
