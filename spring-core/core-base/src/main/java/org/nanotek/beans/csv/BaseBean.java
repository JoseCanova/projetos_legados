package org.nanotek.beans.csv;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.nanotek.BaseInstantiationException;
import org.nanotek.Id;

public  interface BaseBean<K extends Serializable> extends Id<K>{
	static <K extends BaseBean<?>> Optional<K> newInstance(Class<K> clazz) throws BaseInstantiationException { 
		try {
			return Optional.of(clazz.getDeclaredConstructor(null).newInstance());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new BaseInstantiationException(e);
		}
	}
}
