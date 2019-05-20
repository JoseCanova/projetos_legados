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
public class Cache {

	@JsonProperty("readEnabled")
	private Boolean readEnabled;
	@JsonProperty("saveEnabled")
	private Boolean saveEnabled;
	@JsonProperty("endpoint")
	private String endpoint;
	@JsonProperty("timeToLive")
	private Long timeToLive;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("readEnabled")
	public Boolean getReadEnabled() {
		return readEnabled;
	}

	@JsonProperty("readEnabled")
	public void setReadEnabled(Boolean readEnabled) {
		this.readEnabled = readEnabled;
	}

	@JsonProperty("saveEnabled")
	public Boolean getSaveEnabled() {
		return saveEnabled;
	}

	@JsonProperty("saveEnabled")
	public void setSaveEnabled(Boolean saveEnabled) {
		this.saveEnabled = saveEnabled;
	}

	@JsonProperty("endpoint")
	public String getEndpoint() {
		return endpoint;
	}

	@JsonProperty("endpoint")
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	@JsonProperty("timeToLive")
	public Long getTimeToLive() {
		return timeToLive;
	}

	@JsonProperty("timeToLive")
	public void setTimeToLive(Long timeToLive) {
		this.timeToLive = timeToLive;
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
		builder.append("Cache [readEnabled=");
		builder.append(readEnabled);
		builder.append(", saveEnabled=");
		builder.append(saveEnabled);
		builder.append(", endpoint=");
		builder.append(endpoint);
		builder.append(", timeToLive=");
		builder.append(timeToLive);
		builder.append("]");
		return builder.toString();
	}

}