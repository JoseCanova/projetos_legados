package org.nanotek;

import java.io.Serializable;

public interface ArtistEntity<K extends Serializable> {

	K getArtist();
	
}
