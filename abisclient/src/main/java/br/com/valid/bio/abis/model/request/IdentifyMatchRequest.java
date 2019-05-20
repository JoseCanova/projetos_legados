package br.com.valid.bio.abis.model.request;
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
public class IdentifyMatchRequest {

	@JsonProperty("waitTimeout")
	private Long waitTimeout;
	@JsonProperty("referenceImageData")
	private String referenceImageData;
	@JsonProperty("referenceImageType")
	private String referenceImageType;
	@JsonProperty("listSize")
	private Long listSize;
	@JsonProperty("threshold")
	private Long threshold;
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

	@JsonProperty("referenceImageData")
	public String getReferenceImageData() {
		return referenceImageData;
	}

	@JsonProperty("referenceImageData")
	public void setReferenceImageData(String referenceImageData) {
		this.referenceImageData = referenceImageData;
	}

	@JsonProperty("referenceImageType")
	public String getReferenceImageType() {
		return referenceImageType;
	}

	@JsonProperty("referenceImageType")
	public void setReferenceImageType(String referenceImageType) {
		this.referenceImageType = referenceImageType;
	}

	@JsonProperty("listSize")
	public Long getListSize() {
		return listSize;
	}

	@JsonProperty("listSize")
	public void setListSize(Long listSize) {
		this.listSize = listSize;
	}

	@JsonProperty("threshold")
	public Long getThreshold() {
		return threshold;
	}

	@JsonProperty("threshold")
	public void setThreshold(Long threshold) {
		this.threshold = threshold;
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