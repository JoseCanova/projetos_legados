package org.nanotek;

import java.io.Serializable;

public interface BarCode<K extends Serializable , B extends Serializable> extends EntityBase<K>{

	@Override
	default K getId() {
		return get().getId();
	}
	
	@Override
	default void setId(K id) {
		get().setId(id);
	}
	
	default B getBarCode() {
		return get().getBarCode();
	}
    
	default void setBarCode(B B) {
		get().setBarCode(B);
	}
    
	@Override
	default BarCode<K,B> get() {
		return this;
	}
}
