package org.nanotek;

import java.io.Serializable;

public interface MutableTypeBase<K extends Serializable> {

	void setType(K k);
	
}
