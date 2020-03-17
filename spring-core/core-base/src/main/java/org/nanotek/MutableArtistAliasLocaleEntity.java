package org.nanotek;

import java.io.Serializable;

public interface MutableArtistAliasLocaleEntity<K extends Serializable> extends ArtistAliasLocaleEntity<K>{

	void setArtistAliasLocale(K k);
	
}
