package org.nanotek;

import java.util.Optional;

import org.nanotek.csv.PredicateBase;

@FunctionalInterface
public interface Holder<K extends IdBase<?,?> , ID extends IdBase<?,?>>{
	
	Optional<ID> on(PredicateBase<K,ID> predicate);
	
}
