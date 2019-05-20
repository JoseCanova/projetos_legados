package br.com.valid.bio.conveniadas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {

	@JsonProperty("ErrCode")
	private Integer errCode;
	@JsonProperty("Message")
	private String message;

	
	public Error() {} 
	
	@JsonProperty("ErrCode")
	public Integer getErrCode() {
		return errCode;
	}

	@JsonProperty("ErrCode")
	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

	@JsonProperty("Message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("Message")
	public void setMessage(String message) {
		this.message = message;
	}

}
