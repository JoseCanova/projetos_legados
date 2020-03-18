package org.nanotek;

import java.io.Serializable;

import org.nanotek.entities.MutableLength;

public interface LengthBase<T extends Serializable> extends MutableLength<T>{
	
	T getLength();
	
	
}
