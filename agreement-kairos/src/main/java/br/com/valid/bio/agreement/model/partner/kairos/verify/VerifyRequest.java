package br.com.valid.bio.agreement.model.partner.kairos.verify;

	import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown=true)
	@JsonPropertyOrder({
	"image",
	"gallery_name",
	"subject_id"
	})
	public class VerifyRequest {

	@JsonProperty("image")
	private String image;
	@JsonProperty("gallery_name")
	private String galleryName;
	@JsonProperty("subject_id")
	private String subjectId;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonIgnore
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("image")
	public String getImage() {
	return image;
	}

	@JsonProperty("image")
	public void setImage(String image) {
	this.image = image;
	}

	@JsonProperty("gallery_name")
	public String getGalleryName() {
	return galleryName;
	}

	@JsonProperty("gallery_name")
	public void setGalleryName(String galleryName) {
	this.galleryName = galleryName;
	}

	@JsonProperty("subject_id")
	public String getSubjectId() {
	return subjectId;
	}

	@JsonProperty("subject_id")
	public void setSubjectId(String subjectId) {
	this.subjectId = subjectId;
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
