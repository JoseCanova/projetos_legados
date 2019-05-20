package br.com.valid.bio.conveniadas.abis.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionStateEnum {
	
	RECEIVED("received"),
	QUEUED ("queued"), 
	PROCESSING("processing"), 
	DONE("done"), 
	ERROR("error"), 
	CANCELED("canceled"); 
	
	@JsonValue
	private String value; 
	
	private TransactionStateEnum(String value) { 
		this.value = value;
	}
	
	public String value() { 
		return this.value;
	}

}
