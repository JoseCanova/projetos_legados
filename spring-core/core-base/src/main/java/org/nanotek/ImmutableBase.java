package org.nanotek;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.UUID;

public interface ImmutableBase <K extends ImmutableBase<?>> extends Base<K> , KongSupplier<K> {
	
	default UUID getUUId() { 
		return withUUID();
	}
	
	@Override
	default Optional<K> get() {
		return newImmutableBase(this.getClass());
	}
	
	default Optional<K> newImmutableBase(Class<? extends ImmutableBase> class1) throws BaseInstantiationException { 
		try {
			return Optional.of(class1.getDeclaredConstructor(null).newInstance());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new BaseInstantiationException(e);
		}
	}
	
	default UUID withUUID() { 
		UUID uuid = null;
		try { 
				ByteArrayOutputStream bao = new ByteArrayOutputStream();
				ObjectOutputStream oos =  new ObjectOutputStream(bao);
				oos.writeObject(this);
				oos.flush();
				uuid = UUID.nameUUIDFromBytes(bao.toByteArray());
				oos.close();
		}catch (Exception ex) { 
		}
		return Optional.ofNullable(uuid).orElseThrow(BaseException::new);
	}
	
}
