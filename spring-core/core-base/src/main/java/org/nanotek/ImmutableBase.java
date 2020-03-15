package org.nanotek;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.UUID;

public interface ImmutableBase <K extends IdBase<K,ID>,ID extends Serializable> extends KongSupplier<IdBase<K,ID>>  , IdBase<K,ID> {

	default UUID getUUID() { 
		return withUUID();
	}

	@Override
	default Optional<IdBase<K,ID>> get() {
		return Optional.of(this);
	}
	
	static <K extends ImmutableBase<K,ID> , ID extends Serializable> Optional<K> newImmutableBase(Class<K> class1) throws BaseInstantiationException { 
		try {
			return Optional.of(class1.getDeclaredConstructor().newInstance());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new BaseInstantiationException(e);
		}
	}

	static <K extends ImmutableBase<K,ID> ,ID extends Serializable> Optional<K> newInstance(Class<K> clazz , Object[] args , Class<?>... classArgs) throws BaseInstantiationException { 
		try {
			return Optional.of(clazz.getDeclaredConstructor(classArgs).newInstance(args));
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
