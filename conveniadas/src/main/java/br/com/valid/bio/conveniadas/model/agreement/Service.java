package br.com.valid.bio.conveniadas.model.agreement;

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
public class Service {

	@JsonProperty("type")
	private String type;
	@JsonProperty("endpoint")
	private String endpoint;
	@JsonProperty("timeout")
	private Long timeout;
	@JsonProperty("numberOfAttempts")
	private Long numberOfAttempts;
	@JsonProperty("operation")
	private String operation;
	@JsonProperty("method")
	private String method;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("endpoint")
	public String getEndpoint() {
		return endpoint;
	}

	@JsonProperty("endpoint")
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	@JsonProperty("timeout")
	public Long getTimeout() {
		return timeout;
	}

	@JsonProperty("timeout")
	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}

	@JsonProperty("numberOfAttempts")
	public Long getNumberOfAttempts() {
		return numberOfAttempts;
	}

	@JsonProperty("numberOfAttempts")
	public void setNumberOfAttempts(Long numberOfAttempts) {
		this.numberOfAttempts = numberOfAttempts;
	}

	@JsonProperty("operation")
	public String getOperation() {
		return operation;
	}

	@JsonProperty("operation")
	public void setOperation(String operation) {
		this.operation = operation;
	}

	@JsonProperty("method")
	public String getMethod() {
		return method;
	}

	@JsonProperty("method")
	public void setMethod(String method) {
		this.method = method;
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
		StringBuilder builder = new StringBuilder();
		builder.append("Service [type=");
		builder.append(type);
		builder.append(", endpoint=");
		builder.append(endpoint);
		builder.append(", timeout=");
		builder.append(timeout);
		builder.append(", numberOfAttempts=");
		builder.append(numberOfAttempts);
		builder.append(", operation=");
		builder.append(operation);
		builder.append(", method=");
		builder.append(method);
		builder.append("]");
		return builder.toString();
	}

}