package org.nanotek;

import java.io.Serializable;

public interface MutableBase<K extends Serializable> extends Mutable<K>{

	void setId(K id);
	
}
