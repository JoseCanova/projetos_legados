package br.com.valid.bio.conveniadas.model;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {

	@JsonProperty("controlId")
	private String controlId;
	@JsonProperty("errorCode")
	private String errorCode;
	@JsonProperty("errorMessage")
	private String errorMessage;
	@JsonProperty("errorDetails")
	private String errorDetails;
	
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public ErrorMessage() {}
	
	@JsonProperty("controlId")
	public String getControlId() {
		return controlId;
	}

	@JsonProperty("controlId")
	public void setControlId(String controlId) {
		this.controlId = controlId;
	}

	@JsonProperty("errorCode")
	public String getErrorCode() {
		return errorCode;
	}

	@JsonProperty("errorCode")
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@JsonProperty("errorMessage")
	public String getErrorMessage() {
		return errorMessage;
	}

	@JsonProperty("errorMessage")
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@JsonProperty("errorDetails")
	public String getErrorDetails() {
		return errorDetails;
	}

	@JsonProperty("errorDetails")
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return "ErrorMessage [controlId=" + controlId + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage
				+ ", errorDetails=" + errorDetails + ", additionalProperties=" + additionalProperties + "]";
	}
	
}

