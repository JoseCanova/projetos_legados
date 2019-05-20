package org.hubotek.model.project.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="google_api_key")
public class GoogleApiKey extends ApiKey {

	@Column(name="key" , length=255 , insertable=true , updatable=true , nullable=false)
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	
}
