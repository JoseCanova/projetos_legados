package org.nanotek;

import java.util.Optional;

public interface Mutable<K extends IdBase<K,ID>, ID extends Result<?,?>> extends Holder<K,ID> {

	default Optional<ID> mutate (){ 
		return Optional.empty();
	}

}
