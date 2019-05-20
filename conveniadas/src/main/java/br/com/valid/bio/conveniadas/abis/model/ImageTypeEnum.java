package br.com.valid.bio.conveniadas.abis.model;

public enum ImageTypeEnum {

	REFERENCE("reference"), 
	DATA("data");
	
	private String value;

	private ImageTypeEnum(String val) { 
		this.value = val;
	}
	
	
	public String value() { 
		return value;
	}
}
