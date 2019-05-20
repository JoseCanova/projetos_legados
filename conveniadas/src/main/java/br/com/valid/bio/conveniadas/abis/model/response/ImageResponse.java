package br.com.valid.bio.conveniadas.abis.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class ImageResponse extends TransactionResponse {

	
	@JsonProperty("imageKey")
	protected String imageKey;
	
	@JsonProperty("imageType")
	protected String imageType;
	
	@JsonProperty("imageData")
	protected String imageData;
	
	@JsonProperty("imageHash")
	protected String imageHash;
	
	@JsonProperty("imageBehavior")
	protected String imageBehavior;
	
	
	public String getImageKey() {
		return imageKey;
	}

	public void setImageKey(String imageKey) {
		this.imageKey = imageKey;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public String getImageHash() {
		return imageHash;
	}

	public void setImageHash(String imageHash) {
		this.imageHash = imageHash;
	}

	public String getImageBehavior() {
		return imageBehavior;
	}

	public void setImageBehavior(String imageBehavior) {
		this.imageBehavior = imageBehavior;
	}
	
}
