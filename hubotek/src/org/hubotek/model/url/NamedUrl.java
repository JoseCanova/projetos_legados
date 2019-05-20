package org.hubotek.model.url;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="named_url")
@SuppressWarnings("serial")
public class NamedUrl extends BaseUrl{

	@Column(name="name",insertable=true,updatable=true,length=250)
	private String name;
	
	@Column(name="description",insertable=true,updatable=true,length=4000)
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
