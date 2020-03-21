package org.nanotek;

import org.nanotek.stream.KongStream;

public interface WrappedEntityBase<K> extends Wrapper <K>{
	
	default <T extends S , S extends WrappedBaseClass<T,?>>  S prepareBeanInstance(Class<S> clazz) {
		//K, Kong<?>
		return KongStream.of(clazz).add(Base.newInstance(clazz).get()).build().map(i->i).findFirst().get();
	}
}
