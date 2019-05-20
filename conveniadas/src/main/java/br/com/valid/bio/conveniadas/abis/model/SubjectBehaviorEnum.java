package br.com.valid.bio.conveniadas.abis.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SubjectBehaviorEnum {

	VALIDATE ("validate"), 
	CREATE("create");
	
	private String value;
	
	private SubjectBehaviorEnum(String val) {
		this.value = val;
	}

	@JsonValue
	public String value() {
		return value;
	}

}
