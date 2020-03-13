package org.nanotek;

import java.io.Serializable;

public interface LengthBase<T extends Serializable> extends MutableLength<T>{
	
	default T getLength() { 
		return get().getLength();
	}
	
	@Override
	default LengthBase<T> get() {
		return this;
	}
}
