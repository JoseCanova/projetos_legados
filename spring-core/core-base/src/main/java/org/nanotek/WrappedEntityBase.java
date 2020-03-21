package org.nanotek;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.nanotek.beans.csv.BaseBean;

public interface WrappedEntityBase<K extends BaseBean<?>> extends Wrapper <K>{
	
	static <K extends WrappedBaseClass<?> , S extends K , I extends BaseBean<?>> Optional<S> newInstance(Class<I> beanClass) throws BaseInstantiationException { 
		try {
				  Optional<I> baseBean = BaseBean.newInstance(beanClass);
			return WrappedEntityBase.newInstance(WrappedBaseClass.class.asSubclass(WrappedBaseClass.class),  new Serializable[] {beanClass} , Class.class);
		} catch (Exception e) {
			throw new BaseInstantiationException(e);
		}
	}
	
	static <K extends WrappedBaseClass<?>> Optional<K> newInstance(Class<K> clazz , Serializable[] args , Class<?>... classArgs  ) throws BaseInstantiationException { 
		try {
			return Optional.of(clazz.getDeclaredConstructor(classArgs).newInstance(args));
		} catch (Exception e) {
			throw new BaseInstantiationException(e);
		}
	}
	
}
