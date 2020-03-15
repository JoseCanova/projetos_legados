package org.nanotek;

import java.util.Optional;

public interface KongSupplier<K extends Base<?>> {

	Optional<K> get();
	
}
