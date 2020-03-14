package org.nanotek;

import java.io.Serializable;

public interface BarCodeEntityBase<B extends Serializable , K extends Serializable > extends BaseDescriptionBase<B, K>{

	K getId();
	
	B getBarCode();
    
	void setBarCode(B B);
    
}
