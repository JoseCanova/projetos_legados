package org.nanotek;

import java.io.Serializable;

public interface MutableAreaIdEntity<K extends Serializable> extends AreaIdEntity<K>{

	void setAreaId(K k);
	
}
