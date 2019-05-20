package org.hubotek.model.project.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="api_key")
@Inheritance(strategy=InheritanceType.JOINED)
public class ApiKey implements Base<Long>{
	
	@Id
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="api_key_type")
	private ApiKeyEnum apiKeyType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ApiKeyEnum getApiKeyType() {
		return apiKeyType;
	}

	public void setApiKeyType(ApiKeyEnum apiKeyType) {
		this.apiKeyType = apiKeyType;
	}
	
}
