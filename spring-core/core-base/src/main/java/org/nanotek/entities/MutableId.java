package org.nanotek.entities;

import org.nanotek.IdBase;
import org.nanotek.Mutable;
import org.nanotek.Result;

public interface MutableId<K extends IdBase<K,R> , ID extends IdBase<?,?> , R extends Result<?,?>> extends Mutable<K,R>{
	void setId(ID k);
}
