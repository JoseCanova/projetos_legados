package br.com.valid.bio.conveniadas.model.response;

public enum ErrorKeys {

	ERROR_CODE("errorCode"),
	ERROR_DETAILS("errorDetails"), 
	ERROR_MESSAGE("errorMessage");
	
	private String value;
	
	private ErrorKeys(String value) { 
		this.value = value;
	}
	
	public String value() {
		return value;
	}
	
}
