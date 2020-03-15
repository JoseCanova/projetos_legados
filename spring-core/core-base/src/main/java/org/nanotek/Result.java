package org.nanotek;

import java.util.Optional;

public class Result<K extends IdBase<K,K>> implements BooleanBase<K> {

	private static final long serialVersionUID = -307344888633306177L;

	private K id;

	private Optional<K> result;

	public Result() {}

	public Result(K id,Optional<K> result) { 
		this.id = id;
		this.result = result;
	}

	@Override
	public K getId() {
		return id;
	}

	@Override
	public Optional<K> getResult() {
		return result;
	}

}
