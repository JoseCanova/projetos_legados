package org.nanotek;

import java.util.Optional;

public interface KongSupplier<K extends Base<?>> extends Kong<K>{

	default Optional<KongSupplier<K>> get(){
		return Optional.of(this);
	}
	
}
