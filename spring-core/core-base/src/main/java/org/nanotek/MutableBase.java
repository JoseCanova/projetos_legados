package org.nanotek;

import java.io.Serializable;

public interface MutableBase<K extends Serializable> {

	void setId(K id);
	
}
