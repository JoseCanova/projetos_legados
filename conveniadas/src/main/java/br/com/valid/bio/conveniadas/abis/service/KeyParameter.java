package br.com.valid.bio.conveniadas.abis.service;

public class KeyParameter {
	
	private String name;
	
	private String value;

	public KeyParameter(String name , String value){ 
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
