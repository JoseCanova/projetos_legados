package org.nanotek;

import java.io.Serializable;
import java.util.Optional;
import java.util.function.Predicate;

public interface Holder<K extends IdBase<K,ID> , ID extends Serializable> extends IdBase<K,ID>{
	
	Optional<Result<?>> on(Predicate<K> k);
	
}
