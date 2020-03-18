package org.nanotek.beans.entity;

import java.io.Serializable;

import org.nanotek.entities.immutables.AliasIdEntity;

public interface MutableAliasIdEntity<K extends Serializable> extends AliasIdEntity<K>{

	void setAliasId(K k);
	
}
