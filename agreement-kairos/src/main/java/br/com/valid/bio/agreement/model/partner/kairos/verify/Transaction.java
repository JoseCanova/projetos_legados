package br.com.valid.bio.agreement.model.partner.kairos.verify;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction {

	@JsonProperty("status")
	private String status;
	@JsonProperty("subject_id")
	private String subjectId;
	@JsonProperty("quality")
	private Double quality;
	@JsonProperty("width")
	private Long width;
	@JsonProperty("height")
	private Long height;
	@JsonProperty("topLeftX")
	private Long topLeftX;
	@JsonProperty("topLeftY")
	private Long topLeftY;
	@JsonProperty("confidence")
	private Double confidence;
	@JsonProperty("gallery_name")
	private String galleryName;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("subject_id")
	public String getSubjectId() {
		return subjectId;
	}

	@JsonProperty("subject_id")
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	@JsonProperty("quality")
	public Double getQuality() {
		return quality;
	}

	@JsonProperty("quality")
	public void setQuality(Double quality) {
		this.quality = quality;
	}

	@JsonProperty("width")
	public Long getWidth() {
		return width;
	}

	@JsonProperty("width")
	public void setWidth(Long width) {
		this.width = width;
	}

	@JsonProperty("height")
	public Long getHeight() {
		return height;
	}

	@JsonProperty("height")
	public void setHeight(Long height) {
		this.height = height;
	}

	@JsonProperty("topLeftX")
	public Long getTopLeftX() {
		return topLeftX;
	}

	@JsonProperty("topLeftX")
	public void setTopLeftX(Long topLeftX) {
		this.topLeftX = topLeftX;
	}

	@JsonProperty("topLeftY")
	public Long getTopLeftY() {
		return topLeftY;
	}

	@JsonProperty("topLeftY")
	public void setTopLeftY(Long topLeftY) {
		this.topLeftY = topLeftY;
	}

	@JsonProperty("confidence")
	public Double getConfidence() {
		return confidence;
	}

	@JsonProperty("confidence")
	public void setConfidence(Double confidence) {
		this.confidence = confidence;
	}

	@JsonProperty("gallery_name")
	public String getGalleryName() {
		return galleryName;
	}

	@JsonProperty("gallery_name")
	public void setGalleryName(String galleryName) {
		this.galleryName = galleryName;
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
		builder.append("Transaction [status=");
		builder.append(status);
		builder.append(", subjectId=");
		builder.append(subjectId);
		builder.append(", quality=");
		builder.append(quality);
		builder.append(", width=");
		builder.append(width);
		builder.append(", height=");
		builder.append(height);
		builder.append(", topLeftX=");
		builder.append(topLeftX);
		builder.append(", topLeftY=");
		builder.append(topLeftY);
		builder.append(", confidence=");
		builder.append(confidence);
		builder.append(", galleryName=");
		builder.append(galleryName);
		builder.append(", additionalProperties=");
		builder.append(additionalProperties);
		builder.append("]");
		return builder.toString();
	}

}