package org.nanotek.beans.entity;

import java.io.Serializable;

import org.nanotek.ArtistCreditRefCountEntity;

public interface MutableArtistCreditRefCountEntity<K extends Serializable> extends ArtistCreditRefCountEntity<K>{
	
	void setArtistCreditRefCount(K k);

}
