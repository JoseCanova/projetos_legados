package org.nanotek;

import java.io.Serializable;

public interface MutableAreaEntity<K extends Serializable> extends AreaEntity<K>{

	void setArea(K k);
	
}
