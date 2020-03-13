package org.nanotek;

import java.io.Serializable;

public interface EntityBase<K extends Serializable> extends IdBase<K>{
	
	default K getId() { 
		return get().getId();
	}
	
	@Override
	default void setId(K id) {
		get().setId(id);
	}
	
	@Override
	default EntityBase<K> get() { 
		return this;
	}
}
