package br.com.valid.bio.agreement.model.partner.kairos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.valid.bio.agreement.model.Response;
import br.com.valid.bio.agreement.model.partner.kairos.verify.Image;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BaseResponse implements Response {

	private Object typeClass;
	
	@JsonProperty("face_id")
	@JsonAlias("face_id")
	private String id;
	
	@JsonProperty("Errors")
	protected List<Error> errors = null;
	
	@JsonProperty("images")
	private List<Image> images = null;
	
	public BaseResponse() {
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public Object getTypeClass() {
		return typeClass;
	}

	public void setTypeClass(Object typeClass) {
		this.typeClass = typeClass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

}
