package org.hubotek.model.cse.attributes;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 
 * @author JoseCanova
 *
 */

@Entity
@SuppressWarnings("serial")
public class QueryParameterAttribute extends AttributeBase{

	@Column(name="attribute_name" , length=20 , nullable=false)
	private String attributeName;
	
	@Column(name="description" , length=255 , nullable=true)
	private String description;
	
	@Column(name="value" , length=255 , nullable=true)
	private String value;
	
	public QueryParameterAttribute()
	{ 
		this.attributeType = AttributeTypeEnum.QUERY_PARAMETER;
	}
	
	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
