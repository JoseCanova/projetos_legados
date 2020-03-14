package org.nanotek;

import java.io.Serializable;
import java.util.function.Consumer;

public interface EntityBase<K extends Serializable> extends IdBase<K> , MutableBase<K>{
	
	@Override
	default void on(Consumer<K> k) {
		k.accept(getId());
	}
	
}
