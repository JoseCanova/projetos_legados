package br.com.valid.bio.agreement.model.partner.kairos.enroll;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Transaction {

	private String status;
	
	@JsonAlias(value="gallery_name")
	private String galleryName; 
	
	@JsonAlias(value="face_id")
	private String faceId;
	
	private double confidence;
	
	public Transaction() {
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getGalleryName() {
		return galleryName;
	}


	public void setGalleryName(String galleryName) {
		this.galleryName = galleryName;
	}


	public String getFaceId() {
		return faceId;
	}


	public void setFaceId(String faceId) {
		this.faceId = faceId;
	}


	public double getConfidence() {
		return confidence;
	}


	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}


	@Override
	public String toString() {
		return "Transaction [status=" + status + ", galleryName=" + galleryName + ", faceId=" + faceId + ", confidence="
				+ confidence + "]";
	}

}
