package br.com.valid.bio.conveniadas.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseRfbResponse {

	@JsonProperty("code")
	private String code; 

	@JsonProperty("error")
	private String error;

	public BaseRfbResponse() {}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
