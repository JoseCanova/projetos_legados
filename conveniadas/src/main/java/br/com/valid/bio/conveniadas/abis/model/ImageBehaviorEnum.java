package br.com.valid.bio.conveniadas.abis.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ImageBehaviorEnum {

	APPEND_KEEP ("appendKeep"),
	APPEND_DISABLE ("appendDisable"), 
	REPLACE ("replace");
	
	@JsonValue
	private String value;

	private ImageBehaviorEnum(String val) { 
		this.value = val;
	}
	
	public String value() { 
		return value;
	}
	
}
