package br.com.valid.bio.agreement.model.partner.kairos.enroll;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Image {

	@JsonProperty("attributes")
	@JsonAlias("attributes")
	private ImageAttribute imageAtribute;
	
	private Transaction transaction;
	
	public Image() {
	}

	public ImageAttribute getImageAtribute() {
		return imageAtribute;
	}

	public void setImageAtribute(ImageAttribute imageAtribute) {
		this.imageAtribute = imageAtribute;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Image [imageAtribute=" + imageAtribute + ", transaction=" + transaction + "]";
	}
	

}
