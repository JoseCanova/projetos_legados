package org.nanotek;

import java.io.Serializable;

public interface LongIdNameGidEntityBase<K extends Serializable, N extends Serializable> extends LongIdNameEntityBase<N> {

	
	default K getGid() { 
		return get().getGid();
	}
	
	@Override
	default LongIdNameGidEntityBase<K,N> get() {
		return this;
	}
}
