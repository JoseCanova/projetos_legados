package org.nanotek;

import java.io.Serializable;

public interface MutableAreaEndDateEntity<K extends Serializable> extends AreaEndDateEntity<K> {

	void setAreaEndDate(K k);
	
}
