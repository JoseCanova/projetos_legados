package org.nanotek;

import java.io.Serializable;

public interface MutableArtistSortNameEntity<K extends Serializable> extends ArtistSortNameEntity<K> {

	void setArtistSortName(K k);
	
}
