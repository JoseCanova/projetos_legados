package br.com.valid.bio.conveniadas.abis.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FaceTransactionStateEnum {
	
	RECEIVED("received"), 
	QUEUED("queued"),
	PROCESSING("processing"), 
	DONE("done"), 
	ERROR("error"), 
	CANCELED("canceled");
	
	@JsonValue
	private String value;
	
	private FaceTransactionStateEnum(String value) { 
		this.value = value;
	}
	
	public String value() {
		return value;
	}
	
}
