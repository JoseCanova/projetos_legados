package br.com.valid.bio.abis.model.enroll;
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
public class EnrollRequest {

	@JsonProperty("waitTimeout")
	private Long waitTimeout;
	@JsonProperty("subjectBehavior")
	private String subjectBehavior;
	@JsonProperty("subjectKey")
	private String subjectKey;
	@JsonProperty("imageKey")
	private String imageKey;
	@JsonProperty("imageType")
	private String imageType;
	@JsonProperty("imageData")
	private String imageData;
	@JsonProperty("imageBehaviour")
	private String imageBehaviour;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("waitTimeout")
	public Long getWaitTimeout() {
		return waitTimeout;
	}

	@JsonProperty("waitTimeout")
	public void setWaitTimeout(Long waitTimeout) {
		this.waitTimeout = waitTimeout;
	}

	@JsonProperty("subjectBehavior")
	public String getSubjectBehavior() {
		return subjectBehavior;
	}

	@JsonProperty("subjectBehavior")
	public void setSubjectBehavior(String subjectBehavior) {
		this.subjectBehavior = subjectBehavior;
	}

	@JsonProperty("subjectKey")
	public String getSubjectKey() {
		return subjectKey;
	}

	@JsonProperty("subjectKey")
	public void setSubjectKey(String subjectKey) {
		this.subjectKey = subjectKey;
	}

	@JsonProperty("imageKey")
	public String getImageKey() {
		return imageKey;
	}

	@JsonProperty("imageKey")
	public void setImageKey(String imageKey) {
		this.imageKey = imageKey;
	}

	@JsonProperty("imageType")
	public String getImageType() {
		return imageType;
	}

	@JsonProperty("imageType")
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	@JsonProperty("imageData")
	public String getImageData() {
		return imageData;
	}

	@JsonProperty("imageData")
	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	@JsonProperty("imageBehaviour")
	public String getImageBehaviour() {
		return imageBehaviour;
	}

	@JsonProperty("imageBehaviour")
	public void setImageBehaviour(String imageBehaviour) {
		this.imageBehaviour = imageBehaviour;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}