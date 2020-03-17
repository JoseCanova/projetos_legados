package org.nanotek;

import java.io.Serializable;

public interface BarCodeEntity<K extends Serializable> {
  
	K getBarCode();
	
}
