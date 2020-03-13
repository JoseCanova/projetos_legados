package org.nanotek;

import java.io.Serializable;

public interface ImmutableBase <K extends Serializable> extends MutableBase<K>  {
	
	default K getId() { 
		return get().getId();
	};
	
	@Override
	default ImmutableBase<K> get(){ 
		return this;
	}
	
}
