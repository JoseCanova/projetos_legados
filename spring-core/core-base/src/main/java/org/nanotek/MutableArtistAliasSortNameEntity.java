package org.nanotek;

import java.io.Serializable;

public interface MutableArtistAliasSortNameEntity<K extends Serializable> extends ArtistAliasSortNameEntity<K>{
		void setArtistAliasSortName(K k);
}
