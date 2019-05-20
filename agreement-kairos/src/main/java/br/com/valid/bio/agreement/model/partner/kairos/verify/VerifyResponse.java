package br.com.valid.bio.agreement.model.partner.kairos.verify;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.valid.bio.agreement.model.partner.kairos.BaseResponse;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerifyResponse extends BaseResponse {

	@JsonProperty("images")
	private List<Image> images = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("images")
	public List<Image> getImages() {
		return images;
	}

	@JsonProperty("images")
	public void setImages(List<Image> images) {
		this.images = images;
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
		builder.append("VerifyResponse [images=");
		builder.append(images);
		builder.append(", additionalProperties=");
		builder.append(additionalProperties);
		builder.append(", errors=");
		builder.append(errors);
		builder.append("]");
		return builder.toString();
	}
	
}	