package org.nanotek;

import java.io.Serializable;

public interface MutableDescriptionBase<D extends Serializable , ID extends Serializable> extends EntityBase<ID>{

	default void setDescription(D id) {
		get().setDescription(id);
	}
	
	@Override
	default MutableDescriptionBase<D,ID> get() {
		return this;
	}
}
