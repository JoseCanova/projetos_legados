package org.nanotek;

import java.util.function.Consumer;

public class Result<K extends IdBase<Boolean>> implements BooleanBase<K> {

	private static final long serialVersionUID = -307344888633306177L;
	
	private Boolean id;
	
	private K result;

	public Result() {}
	
	public Result(Boolean value , Boolean result) { 
		this.id = value;
	}

	public Boolean getId() {
		return id;
	}

	public K getResult() {
		return result;
	}

}
