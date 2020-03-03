package org.nanotek;

public class Result implements BooleanBase<Boolean> {

	private static final long serialVersionUID = -307344888633306177L;
	
	private Boolean id;

	public Result() {}
	
	public Result(Boolean value) { 
		this.id = value;
	}
	
	@Override
	public Boolean getId() {
		return id;
	}

	@Override
	public void setId(Boolean id) {
		this.id = id;
	}
	
}
