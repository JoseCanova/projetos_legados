package org.nanotek;

import java.io.Serializable;

public interface MutableAreaBeginDateEntity<K extends Serializable> extends AreaBeginDateEntity<K>{

	void setAreaBeginDate(K k);
	
}
