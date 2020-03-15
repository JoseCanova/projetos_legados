package org.nanotek;

import java.io.Serializable;

public interface BarCodeEntityBase<K extends Serializable , ID extends Serializable > extends IdBase<ID>{

	ID getId();
	
	K getBarCode();
    
	void setBarCode(K B);
    
}
