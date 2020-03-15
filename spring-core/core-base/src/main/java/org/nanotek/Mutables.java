package org.nanotek;

import java.io.Serializable;
import java.util.Optional;
import java.util.function.Predicate;

public interface Mutables<K extends Serializable>  extends IdBase<K> , MutableBase<K>{

	@Override
	default <B extends Base<?>> Optional<Result<?>> on(Predicate<K> k) {
		return Optional.of(new Result<>(k.test(getId()),this));
	}
	
	
}
