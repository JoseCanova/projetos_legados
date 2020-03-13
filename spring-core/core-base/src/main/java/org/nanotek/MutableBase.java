package org.nanotek;

import java.io.Serializable;

public interface MutableBase<K extends Serializable> extends Base<MutableBase<K>>{

	default void setId(K id) { 
		get().setId(id);
	};

	@Override
	default MutableBase<K> get() { 
		return this;
	}
	
}
