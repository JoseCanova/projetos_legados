package org.nanotek;

import java.util.Optional;
import java.util.function.Predicate;

@FunctionalInterface
public interface Holder<K> {
	
	<B extends Base<?>> Optional<Result<?>> on(Predicate<K> k);
	
}
