package org.nanotek;

import java.io.Serializable;

public interface MutableBarCodeEntity<K extends Serializable> extends BarCodeEntity<K> {

	void setBarCode(K k);
	
}
