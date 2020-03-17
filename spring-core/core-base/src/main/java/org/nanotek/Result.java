package org.nanotek;

import java.util.Optional;

import org.nanotek.csv.PredicateBase;

public class Result<K extends IdBase<K,ID> , ID extends IdBase<?,?>> implements BooleanBase<K,ID>  , Holder<K, ID> {

	private static final long serialVersionUID = -307344888633306177L;

	private K immutable;
	
	private ID id = null;

	public Result() {}
	
	public Result(K immutable) { 
		this.immutable = immutable;
	}

	@Override
	public ID getId() {
		return Optional.ofNullable(id).orElseThrow(BaseException::new);
	}

	@Override
	public Optional<ID> on(PredicateBase<K, ID> predicate) {
		return predicate.evaluate(immutable);
	}


}
