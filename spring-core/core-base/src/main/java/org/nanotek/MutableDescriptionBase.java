package org.nanotek;

import java.io.Serializable;

public interface MutableDescriptionBase<ID extends Serializable , D extends Serializable> extends EntityBase<ID>{

	default void setDescription(D id) {
		get().setDescription(id);
	}
	
	@Override
	default MutableDescriptionBase<ID,D> get() {
		return this;
	}
}
