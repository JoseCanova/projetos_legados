package org.nanotek;

import java.io.Serializable;

public interface BarCode<B extends Serializable , K extends Serializable > extends BaseDescriptionBase<B, K>{

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
	default BarCode<B,K> get() {
		return this;
	}
}
