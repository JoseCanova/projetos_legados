package org.nanotek;

import java.io.Serializable;
import java.util.Optional;

import org.nanotek.stream.KongStream;

public interface IdBase<K extends Base<K>,ID extends Serializable> extends Base<K> , Id<ID> {
	
	default Optional<?> createPkInstance(Class<K> k , Class<ID> i){
		return Base.newInstance(k, new Serializable[] {i} , i);
	}
	
	static <T extends S , S extends IdBase<T,?>>  S prepareBeanInstance(Class<S> clazz) {
		//K, Kong<?>
		return KongStream.of(clazz).add(Base.newInstance(clazz).get()).build().map(i->i).findFirst().get();
	}
	
	default IdBase<K,ID> getIdBase(){
		return this;
	}
}
