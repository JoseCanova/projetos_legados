package org.nanotek;

import java.util.Optional;

public interface KongSupplier<K extends Base<?>> extends Base<K>{

	Optional<K> get();
	
}
