package org.nanotek;

import java.util.function.Consumer;

@FunctionalInterface
public interface Holder<K> {
	
	<B extends Base<?>> B on(Consumer<K> k);
	
}
