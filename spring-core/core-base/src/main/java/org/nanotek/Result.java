package org.nanotek;

public abstract class Result<K extends IdBase<?>> implements BooleanBase<K> {

	private static final long serialVersionUID = -307344888633306177L;
	
	private Boolean id;
	
	private K result;

	public Result() {}
	
	public Result(Boolean value , K result) { 
		this.id = value;
		this.result = result;
	}

	public Boolean getId() {
		return id;
	}

	public K getResult() {
		return result;
	}
}
