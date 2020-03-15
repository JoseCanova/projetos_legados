package org.nanotek;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public interface ImmutableBase <K extends IdBase<?> , B extends Base<?>> extends KongSupplier<ImmutableBase<K,B>>  , IdBase<K> , Holder<K>{

	//	default <B extends Base<?>> Optional<Result<?,?>> onOld(Predicate<K> k) {
	//		return Optional.of(new Result<>(this,k.test(this.getId())));
	//	}
    
	@Override
	default Optional<Result<K, K>> on(Predicate<K> k) {
		return Optional.of(value);
	}
	
	default UUID getUUID() { 
		return withUUID();
	}

	@Override
	default Optional<ImmutableBase<K,B>> get() {
		return Optional.ofNullable(this);
	}	

	static <K extends ImmutableBase<K,B> , B extends Base<?>> Optional<K> newImmutableBase(Class<K> class1) throws BaseInstantiationException { 
		try {
			return Optional.of(class1.getDeclaredConstructor(null).newInstance());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new BaseInstantiationException(e);
		}
	}

	default Optional<K> newInstance(Class<K> clazz , Object[] args , Class<?>... classArgs) throws BaseInstantiationException { 
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
