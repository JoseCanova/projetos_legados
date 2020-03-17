package org.nanotek;

import java.io.Serializable;

import org.nanotek.beans.entity.ArtistAliasTypeEntity;

public interface MutableArtistAliasTypeEntity<K extends Serializable> extends ArtistAliasTypeEntity<K> {

	void setArtistAliasType(K k);
	
}
