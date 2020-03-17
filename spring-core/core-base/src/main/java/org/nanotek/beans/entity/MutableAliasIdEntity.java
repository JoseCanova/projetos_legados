package org.nanotek.beans.entity;

import java.io.Serializable;

public interface MutableAliasIdEntity<K extends Serializable> {

	void setAliasId(K k);
	
}
