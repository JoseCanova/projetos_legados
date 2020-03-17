package org.nanotek;

import java.io.Serializable;

public interface MutableArtistAliasEndDateEntity<K extends Serializable> extends ArtistAliasEndDateEntity<K>{

	void setArtistAliasEndDate(K k);
	
}
