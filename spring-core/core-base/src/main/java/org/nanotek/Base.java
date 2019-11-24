package org.nanotek;

import java.io.Serializable;
import java.util.Optional;
import java.util.function.Supplier;

import org.nanotek.beans.ArtistCreditName;

public interface Base<K extends Serializable> extends Identifiable <K>  {

	public void setId(K id);
	
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

	public default Base<?> newInstance() throws InstantiationException, IllegalAccessException{ 
		return this.getClass().newInstance();
	}
	
	public static <K extends Base<?>> Optional<K> NULL_VALUE(Class<K> clazz) {
		try {
			return Optional.of(clazz.newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
