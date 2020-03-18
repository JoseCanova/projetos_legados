package org.nanotek;

import java.io.Serializable;

public interface MutableArtistTypeEntity<K extends Serializable> extends ArtistTypeEntity<K>{
				void setArtistType(K k);
}
