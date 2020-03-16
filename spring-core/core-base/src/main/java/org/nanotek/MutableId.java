package org.nanotek;

import java.io.Serializable;

public interface MutableId<K extends IdBase<K,R> , ID extends Serializable , R extends Result<?,?>> extends Mutable<K,R>{
	void setId(ID k);
}
