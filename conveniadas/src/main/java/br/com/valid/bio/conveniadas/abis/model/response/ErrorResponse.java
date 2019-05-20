package br.com.valid.bio.conveniadas.abis.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse implements StatableResponse {

	@JsonProperty("errorCode")
	protected String errorCode;
	
	@JsonProperty("errorMessage")
	protected String errorMessage;
	
	@JsonProperty("errorDetails")
	protected String errorDetails;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
}
