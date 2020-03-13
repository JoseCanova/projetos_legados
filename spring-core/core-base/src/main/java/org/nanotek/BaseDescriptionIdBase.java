package org.nanotek;

import java.io.Serializable;

public interface BaseDescriptionIdBase<K extends Serializable, ID extends Serializable> extends BaseDescriptionBase<K,ID>  {
	
	K getDescriptionId();
	
	void setDescriptionId(K id);
	
	@Override
	default K getDescription() { 
		return get().getDescription();
	}
	
	@Override
	default BaseDescriptionIdBase<K,ID> get() { 
		return this;
	}

}
