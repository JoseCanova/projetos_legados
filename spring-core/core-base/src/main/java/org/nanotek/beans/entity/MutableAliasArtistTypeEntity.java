package org.nanotek.beans.entity;

import java.io.Serializable;

public interface MutableAliasArtistTypeEntity<K extends Serializable> extends ArtistAliasTypeEntity<K>{
	void setArtistAliasType(K k);
}
