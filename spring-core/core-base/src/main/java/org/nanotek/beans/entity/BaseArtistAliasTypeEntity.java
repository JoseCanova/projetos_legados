package org.nanotek.beans.entity;

import org.nanotek.BaseEntity;

public interface BaseArtistAliasTypeEntity<K extends ArtistAlias<?>> extends BaseEntity<ArtistAliasType<?>>{
	
	K getArtistAlias();
	void setArtistAlias(K k);
	
}
