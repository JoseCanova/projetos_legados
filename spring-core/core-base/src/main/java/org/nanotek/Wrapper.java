package org.nanotek;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public interface Wrapper<K> extends Kong<Wrapper<?>>{
	default <S extends Wrapper<K>> Optional<S> asWrapper(Class<S> clazz) {
		return withWrapper(this.getClass());
	};
	static <S extends Wrapper<J> , J> Optional<S> withWrapper(Class<S> clazz) throws BaseInstantiationException { 
		try {
			return Optional.of(clazz.getDeclaredConstructor().newInstance());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new BaseInstantiationException(e);
		}
	}
}
