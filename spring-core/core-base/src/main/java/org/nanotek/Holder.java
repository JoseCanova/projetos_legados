package org.nanotek;

import java.util.Optional;

import org.nanotek.Result;
import org.nanotek.csv.PredicateBase;

@FunctionalInterface
public interface Holder<K extends IdBase<K,ID> , ID extends IdBase<?,?>>{
	
	Optional<ID> on(PredicateBase<K,ID> predicate);
	
	default <J extends IdBase<J,L> , L extends ID> Result<J,L> with(J k) {
				return new Result<J,L>(k);
	}
	
	
}
