package org.nanotek;

import java.io.Serializable;

public interface MutableArtistAliasBeginDateEntity<K extends Serializable> extends ArtistAliasBeginDateEntity<K>{

	void setArtistAliasBeginDate(K k);
	
}
