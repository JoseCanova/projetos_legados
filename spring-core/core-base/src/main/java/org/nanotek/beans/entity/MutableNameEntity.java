package org.nanotek.beans.entity;

import java.io.Serializable;

public interface MutableNameEntity<K extends Serializable> extends  NameEntity<K>{

	void setName(K k);
	
}
