package org.nanotek;

public interface MutableLength<T> extends Base<MutableLength<T>>{

	default void setLength(MutableLength<T> l) { 
		get().setLength(l);
	}
	
	@Override
	default MutableLength<T> get() {
		return this;
	}
	
}
