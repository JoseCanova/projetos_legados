package br.com.valid.bio.model.abis.biographic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.valid.bio.abis.model.Base;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonResponse implements Base<String> {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("document")
	private String document; 
	
	@JsonProperty("birthDate")
	private String birthDate;
	
	@JsonProperty("code")
	private String code; 

	@JsonProperty("error")
	private String error;
	
	public PersonResponse() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() { 
		return "0";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "PersonResponse [name=" + name + ", document=" + document + ", birthDate=" + birthDate + ", code=" + code
				+ ", error=" + error + "]";
	}
}
