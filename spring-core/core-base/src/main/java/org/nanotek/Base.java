package org.nanotek;

import java.io.Serializable;
import java.util.Optional;
import java.util.function.Supplier;

import com.google.gson.Gson;

public interface Base<K extends Serializable> extends Identifiable <K>  {

	public void setId(K id);
	
	
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
	
	default <T extends Base<?>> T newType(Supplier<T> baseSupplier)
	{ 
		return baseSupplier.get();
	}

	default Base<?> newInstance() throws InstantiationException, IllegalAccessException{ 
		return this.getClass().newInstance();
	}
	
	static <K extends Base<?>> Optional<K> NULL_VALUE(Class<K> clazz) {
		return Optional.empty();
	}
}
