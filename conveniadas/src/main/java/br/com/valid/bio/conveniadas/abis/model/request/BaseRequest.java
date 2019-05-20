package br.com.valid.bio.conveniadas.abis.model.request;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.valid.bio.conveniadas.abis.model.ImageTypeEnum;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseRequest {

	@JsonProperty("waitTimeout")
	private Long waitTimeout;
	@JsonProperty("referenceImageData")
	private String referenceImageData;
	@JsonProperty("referenceImageType")
	private ImageTypeEnum referenceImageType;
	@JsonProperty("listSize")
	private Long listSize;
	@JsonProperty("threshold")
	private Float threshold;
	
	@JsonProperty("subjectTags")
	private List<String> subjectTags = null;
	
	@JsonProperty("referenceImageToken")
	private String referenceImageToken;
	
	@JsonProperty("probeImageType")
	private String probeImageType;
	
	@JsonProperty("probeImageData")
	private String probeImageData;
	
	@JsonProperty("probeImageToken")
	private String probeImageToken;
	
	@JsonProperty("probeImageKey")
	private String probeImageKey;
	
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public BaseRequest() {}
	
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
	public ImageTypeEnum getReferenceImageType() {
		return referenceImageType;
	}

	@JsonProperty("referenceImageType")
	public void setReferenceImageType(ImageTypeEnum referenceImageType) {
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
	public Float getThreshold() {
		return threshold;
	}

	@JsonProperty("threshold")
	public void setThreshold(Float threshold) {
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

	public List<String> getSubjectTags() {
		return subjectTags;
	}

	public void setSubjectTags(List<String> subjectTags) {
		this.subjectTags = subjectTags;
	}

	public String getReferenceImageToken() {
		return referenceImageToken;
	}

	public void setReferenceImageToken(String referenceImageToken) {
		this.referenceImageToken = referenceImageToken;
	}

	public String getProbeImageType() {
		return probeImageType;
	}

	public void setProbeImageType(String probeImageType) {
		this.probeImageType = probeImageType;
	}

	public String getProbeImageData() {
		return probeImageData;
	}

	public void setProbeImageData(String probeImageData) {
		this.probeImageData = probeImageData;
	}

	public String getProbeImageToken() {
		return probeImageToken;
	}

	public void setProbeImageToken(String probeImageToken) {
		this.probeImageToken = probeImageToken;
	}

	public String getProbeImageKey() {
		return probeImageKey;
	}

	public void setProbeImageKey(String probeImageKey) {
		this.probeImageKey = probeImageKey;
	}

	@Override
	public String toString() {
		return "BaseRequest [waitTimeout=" + waitTimeout + ", referenceImageData=" + referenceImageData
				+ ", referenceImageType=" + referenceImageType + ", listSize=" + listSize + ", threshold=" + threshold
				+ ", subjectTags=" + subjectTags + ", referenceImageToken=" + referenceImageToken + ", probeImageType="
				+ probeImageType + ", probeImageData=" + probeImageData + ", probeImageToken=" + probeImageToken
				+ ", probeImageKey=" + probeImageKey + ", additionalProperties=" + additionalProperties + "]";
	}
	
}