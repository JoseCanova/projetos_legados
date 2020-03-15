package org.nanotek;

import java.util.Optional;
import java.util.function.Predicate;

public interface Holder<K extends IdBase<?>> extends IdBase<K>{
	
	default Optional<Result<K, K>> on(Predicate<K> k) {
		return Optional.of(new Result<>(this.getId(),Optional.of(this.getId())));
	}
	
}
