package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.BarCodeEntity;

public interface MutableBarCodeEntity<K extends Serializable> extends BarCodeEntity<K> {

	void setBarCode(K k);
	
}
