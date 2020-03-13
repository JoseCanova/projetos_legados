package org.nanotek;

import java.io.Serializable;

public interface IdNameBase<K extends Serializable, N extends Serializable> extends  EntityNameBase<K, N> {

	@Override
	default K getId() {
		return get().getId();
	}
	
	@Override
	default void setId(K id) {
		get().setId(id);
	}
	
	@Override
	default IdNameBase<K,N> get(){ 
		return this;
	}
}
