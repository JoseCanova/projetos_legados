package org.nanotek;

import java.io.Serializable;
import java.util.Optional;
 
public interface IdBase<K extends Serializable> extends Base<IdBase<K>> , Id<K> {

	
	K getId();
		
	@Override
	default Optional<IdBase<K>> get() { 
		return Optional.ofNullable(this);
	}

}
