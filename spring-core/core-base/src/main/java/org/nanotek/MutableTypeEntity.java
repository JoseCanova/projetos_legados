package org.nanotek;

import java.io.Serializable;

public interface MutableTypeEntity<K extends Serializable> extends TypeEntity<K>{

	void setType(K k);
	
}
