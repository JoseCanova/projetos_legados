package org.nanotek;

import java.io.Serializable;

public interface BaseTypeDescriptionBase<K extends IdBase<K,ID>,D extends Serializable , ID extends Serializable> extends BaseDescriptionBase<K,K, ID> , ImmutableGid<K>{
	
	ID getTypeId();
	
	void setTypeId(ID id);
	
	K getGid();
}
