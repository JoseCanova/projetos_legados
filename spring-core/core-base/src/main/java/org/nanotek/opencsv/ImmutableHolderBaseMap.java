package org.nanotek.opencsv;

import java.util.Optional;

import org.nanotek.BaseException;
import org.nanotek.BooleanBase;
import org.nanotek.Holder;
import org.nanotek.IdBase;

public class ImmutableHolderBaseMap<K extends IdBase<K,ID> , ID extends IdBase<?,?>> 
extends HolderBaseMap<K,ID> 
implements BooleanBase<K,ID> , Holder<K,ID>{

	private static final long serialVersionUID = 169642302691421237L;
	
	public ImmutableHolderBaseMap(K immutable, ID id) {
		super(immutable, id);
	}

	public ImmutableHolderBaseMap(K k) {
		super(k);
	}
	
	public Optional<ID> compute (PredicateBase<K, ID>  predicate){
		return Optional.ofNullable(predicate.evaluate(immutable)).orElseThrow(BaseException::new);
	}

}
