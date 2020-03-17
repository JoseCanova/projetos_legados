package org.nanotek;

public interface MutableId<K extends IdBase<K,R> , ID extends IdBase<?,?> , R extends Result<?,?>> extends Mutable<K,R>{
	void setId(ID k);
}
