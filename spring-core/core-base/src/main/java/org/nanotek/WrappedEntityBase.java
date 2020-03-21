package org.nanotek;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.nanotek.beans.csv.BaseBean;

public interface WrappedEntityBase<K extends BaseBean<?>> extends Wrapper <K>{
	
//	default <T extends S , S extends WrappedBaseClass<?,?>>  S prepareBeanInstance(Class<S> clazz) {
//		//K, Kong<?>
////		return KongStream.of(clazz).add(Base.newInstance(clazz).get()).build().map(i->i).findFirst().get();
//	}
	
//	static <K extends WrappedBaseClass<?> , S extends K> Optional<S> newWrappedInstance(Class<S> s) throws BaseInstantiationException { 
//		try {
//			return Optional.of(new WrappedBaseClass(BaseBean.newInstance(s)get()));
//		} catch ( SecurityException e) {
//			throw new BaseInstantiationException(e);
//		}
//	}
	
}
