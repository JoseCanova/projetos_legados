package org.nanotek;

import java.util.Optional;

public class Result<K extends IdBase<?>> implements BooleanBase<K> {

	private static final long serialVersionUID = -307344888633306177L;
	
	private K id;
	
	private Optional<Boolean> result;

	public Result() {}
	
	public Result(K id,Boolean result) { 
		this.id = id;
	}

	public K getId() {
		return id;
	}

	public Optional<Boolean> getResult() {
		return result;
	}



}
