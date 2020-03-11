package org.nanotek;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.function.Supplier;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.gson.Gson;

public interface Base extends Serializable {

	static String hash = "35454B055CC325EA1AF2126E27707052";

	default String md5Digest()  { 
		return DigestUtils.md5Hex(toJson()).toUpperCase();
	}

	default String toJson () 
	{ 
		return new Gson().toJson(this);
	}


	default <T> T newAnyType(Supplier<T> supplier)
	{ 
		return supplier.get();
	}

	default <T> T ofNullable(T dest , Supplier<T> supplier) 
	{ 
		return Optional.ofNullable(dest).orElseGet(supplier); 
	}

	default <T extends Base> T newType(Supplier<T> baseSupplier)
	{ 
		return baseSupplier.get();
	}

	default Base newInstance() throws BaseInstantiationException { 
		try {
			return this.getClass().getDeclaredConstructor(null).newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new BaseInstantiationException(e);
		}
	}

	static <K extends Base> Optional<K> newInstance(Class<K> clazz , Object[] args , Class<?>... classArgs  ) throws BaseInstantiationException { 
		try {
			return Optional.of(clazz.getDeclaredConstructor(classArgs).newInstance(args));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new BaseInstantiationException(e);
		}
	}

	
	static <K extends Base> Optional<K> NULL_VALUE(Class<K> clazz) {
		return Optional.empty();
	}
}
