package org.nanotek;

import java.io.Serializable;

public interface BaseTypeDescriptionBase<K extends Serializable,D extends Serializable , ID extends Serializable> extends BaseDescriptionBase<D, ID> , ImmutableGid<K>{
	
	D getDescription();
	
	void setId(ID id);
	
	ID getTypeId();
	
	void setTypeId(ID id);
	
	K getGid();
}
