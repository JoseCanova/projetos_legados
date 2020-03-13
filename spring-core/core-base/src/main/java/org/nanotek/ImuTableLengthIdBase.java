package org.nanotek;

import java.io.Serializable;

public interface ImuTableLengthIdBase<K extends Serializable, ID extends Serializable> extends IdBase<ID>{

	
	default K getLength() { 
		return get().getLength();
	}
	
	@Override
	default ImuTableLengthIdBase<K,ID> get() {
		return this;
	}
}
