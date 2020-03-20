package org.nanotek;

import java.io.Serializable;
import java.util.Optional;

public interface IdBase<K extends IdBase<?,ID>,ID extends Serializable> extends Base<IdBase<K,ID>> , Id<ID> {
	
	default Optional<?> createPkInstance(Class<K> k , Class<ID> i){
		return Base.newInstance(k, new Serializable[] {i} , i);
	}
	
	default IdBase<K,ID> getIdBase(){
		return this;
	}
}
