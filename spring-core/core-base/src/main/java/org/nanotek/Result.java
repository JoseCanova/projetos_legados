package org.nanotek;

import java.util.Optional;

public class Result<K extends IdBase<?> , ID extends IdBase<?>> implements BooleanBase<K,ID> {

	private static final long serialVersionUID = -307344888633306177L;
	
	private K id;
	
	private Optional<ID> result;

	public Result() {}
	
	public Result(K id,Optional<ID> result) { 
		this.id = id;
		this.result = result;
	}

	public K getId() {
		return id;
	}

	public Optional<ID> getResult() {
		return result;
	}

}
