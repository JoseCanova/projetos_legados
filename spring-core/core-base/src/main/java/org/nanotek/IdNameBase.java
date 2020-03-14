package org.nanotek;

import java.io.Serializable;

import com.google.common.base.Supplier;

public interface IdNameBase<K extends Serializable, ID extends Serializable> extends  MutableNameBase<K> , Supplier<IdNameBase<K,ID>>{

	default ID getId() {
		return get().getId();
	}
	
	default void setId(ID id) {
		get().setId(id);
	}
	
	default IdNameBase<K,ID> get(){ 
		return this;
	}
}
