package br.com.valid.bio.conveniadas.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.valid.bio.conveniadas.model.Response;

public abstract class BaseResponse implements Response{

	@JsonProperty("Errors")
	protected List<Error> errors = null;
	
	public BaseResponse() {
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

}
