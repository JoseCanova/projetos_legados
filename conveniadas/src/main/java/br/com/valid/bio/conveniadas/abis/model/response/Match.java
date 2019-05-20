package br.com.valid.bio.conveniadas.abis.model.response;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Match {

	@JsonProperty("imageKey")
	private String imageKey;
	@JsonProperty("score")
	private String score;
	
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("imageKey")
	public String getImageKey() {
		return imageKey;
	}

	@JsonProperty("imageKey")
	public void setImageKey(String imageKey) {
		this.imageKey = imageKey;
	}

	@JsonProperty("score")
	public String getScore() {
		return score;
	}

	@JsonProperty("score")
	public void setScore(String score) {
		this.score = score;
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
		return "Match [imageKey=" + imageKey + ", score=" + score + ", additionalProperties=" + additionalProperties
				+ "]";
	}

}