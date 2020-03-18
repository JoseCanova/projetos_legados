package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.LongIdNameEntity;

public interface MutableLongIdNameEntity<K extends Serializable> extends LongIdNameEntity<K>{
	
	void setName(K k);

}
