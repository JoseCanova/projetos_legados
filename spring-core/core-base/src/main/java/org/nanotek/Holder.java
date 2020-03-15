package org.nanotek;

import java.util.Optional;
import java.util.function.Consumer;

@FunctionalInterface
public interface Holder<K> {
	
	<B extends Base<?>> Optional<B> on(Consumer<K> k);
	
}
