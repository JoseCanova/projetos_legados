package org.nanotek;

import java.io.Serializable;
import java.util.Optional;

public interface KongSupplier<K extends Serializable> {

	Optional<K> get();
	
}
