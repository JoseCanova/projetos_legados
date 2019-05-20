package br.com.valid.bio.conveniadas.model.person;

import br.com.valid.bio.conveniadas.model.BaseRfbResponse;

public class PersonData extends BaseRfbResponse {

	private String name; 
	
	private String birthDate; 
	
	private String document;

	public PersonData() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}
	
}
