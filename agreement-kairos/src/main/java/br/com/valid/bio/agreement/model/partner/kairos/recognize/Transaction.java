package br.com.valid.bio.agreement.model.partner.kairos.recognize;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Transaction {

    
    private String status; 

    private Integer width; 
	
    private Integer topLeftX; 
	
    private Integer topLeftY; 
	
	@JsonAlias("gallery_name")
	@JsonProperty("gallery_name")
	private String galleryName; 
	
	@JsonAlias("face_id")
	@JsonProperty("face_id")
	private String faceId;
	
	private Double confidence;
	
	@JsonAlias("subject_id")
	@JsonProperty("subject_id")
	private String subjectId; 
	
	private Integer height; 
	
	private Double quality;
	
	public Transaction() {}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getTopLeftX() {
		return topLeftX;
	}

	public void setTopLeftX(Integer topLeftX) {
		this.topLeftX = topLeftX;
	}

	public Integer getTopLeftY() {
		return topLeftY;
	}

	public void setTopLeftY(Integer topLeftY) {
		this.topLeftY = topLeftY;
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

	public Double getConfidence() {
		return confidence;
	}

	public void setConfidence(Double confidence) {
		this.confidence = confidence;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Double getQuality() {
		return quality;
	}

	public void setQuality(Double quality) {
		this.quality = quality;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [status=");
		builder.append(status);
		builder.append(", width=");
		builder.append(width);
		builder.append(", topLeftX=");
		builder.append(topLeftX);
		builder.append(", topLeftY=");
		builder.append(topLeftY);
		builder.append(", galleryName=");
		builder.append(galleryName);
		builder.append(", faceId=");
		builder.append(faceId);
		builder.append(", confidence=");
		builder.append(confidence);
		builder.append(", subjectId=");
		builder.append(subjectId);
		builder.append(", height=");
		builder.append(height);
		builder.append(", quality=");
		builder.append(quality);
		builder.append("]");
		return builder.toString();
	}

}
