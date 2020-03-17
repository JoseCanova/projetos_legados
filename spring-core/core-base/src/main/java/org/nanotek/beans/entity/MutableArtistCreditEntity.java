package org.nanotek.beans.entity;

import java.io.Serializable;

public interface MutableArtistCreditEntity<K extends Serializable> {

	void setArtistCredit(K k);
	
}
