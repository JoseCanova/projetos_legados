package br.com.valid.bio.agreement.model.partner.kairos.enroll;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * Proposito - monta objeto de requisicao (enroll) para API Kairos.
 * 
 * @author jose.canova
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class EnrollRequest {

	private String image;
	
	@SerializedName("subject_id")
	@JsonAlias(value="subject_id")
	@JsonProperty("subject_id")
	private String subjectId;
	
	@SerializedName("gallery_name")
	@JsonAlias(value="gallery_name")
	@JsonProperty("gallery_name")
	private String galleryName;

	@JsonIgnore
	private String url;

	public EnrollRequest() {
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getGalleryName() {
		return galleryName;
	}

	public void setGalleryName(String galleryName) {
		this.galleryName = galleryName;
	}

	@Override
	public String toString() {
		return "EnrollRequest [image=" + image + ", subjectId=" + subjectId + ", galleryName=" + galleryName + "]";
	}
	
}
