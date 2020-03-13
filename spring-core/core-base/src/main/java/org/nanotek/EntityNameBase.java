package org.nanotek;

import java.io.Serializable;

public interface EntityNameBase<T extends Serializable, N extends Serializable> extends EntityBase<T>{
	
	default void setName(N n) { 
		get().setName(n);
	}
	
	@Override
	default EntityNameBase<T,N> get() {
		return this;
	}
}
