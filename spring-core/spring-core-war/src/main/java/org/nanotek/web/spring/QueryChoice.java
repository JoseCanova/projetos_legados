package org.nanotek.web.spring;


enum QueryChoice{ 
	
	BY_NAME ( 1 , "By Name"),
	BY_NAME_IGNORECASE (2 , "By Name Ignore Case"),
	BY_NAME_LIKEIGNORECASE (3 , "By Name Ignore Case Like"); 
	
	private Integer value;
	private String type;

	private QueryChoice (Integer value , String type)
	{ 
		this.value = value; 
		this.type = type;
	}

	public Integer getValue() {
		return value;
	}

	public String getType() {
		return type;
	}
	
}
