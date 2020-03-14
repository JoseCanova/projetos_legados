package org.nanotek;

import java.io.Serializable;

public interface LengthBase<T extends Serializable> extends MutableLength<T>{
	
	T getLength();
	
	
}
