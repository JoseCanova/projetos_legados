package org.nanotek;

import java.io.Serializable;

public interface BaseTypeBase<K extends Serializable,ID extends Serializable> extends BaseDescriptionBase<K, ID> , GidBase<K>{
	
	@Override
	default K getDescription() {
		return get().getDescription();
	}
	
	@Override
	default void setId(ID id) {
		get().setId(id);
	}
	
	default ID getTypeId() { 
		return get().getTypeId();
	}
	
	default void setTypeId(ID id) {
		get().setId(id);
	}
	
	@Override
	default K getGid() {
		return get().getGid();
	}
	
	@Override
	default BaseTypeBase<K, ID> get() {
		return this;
	}
}
