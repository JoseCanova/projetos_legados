package org.nanotek;

import java.util.function.Consumer;

public interface LongBase extends EntityBase<Long>{

	@Override
	default void on(Consumer<Long> k) {
		k.accept(getId());
	}
}
