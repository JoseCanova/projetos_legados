package org.hubotek.model;

import org.hubotek.ElementEnum;

public enum AccountStatusEnum implements ElementEnum<Boolean>{

	ACTIVE(true),
	INACTIVE(false);
	
	
	private Boolean value;

	private AccountStatusEnum(Boolean status)
	{ 
		this.value = status;
	}

	@Override
	public Boolean valueOf() {
		return value;
	}
	
	
	
	
}
