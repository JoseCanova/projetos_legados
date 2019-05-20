package org.hubotek.service.database;

import org.hubotek.model.project.api.ApiKeyEnum;
import org.hubotek.model.project.api.GoogleApiKey;
import org.springframework.stereotype.Service;

@Service
public class GoogleApiKeyDAO extends BaseDAO<Long , GoogleApiKey>{

	public GoogleApiKey findApiKeyByNameType(String name , ApiKeyEnum keyType)
	{ 
		return entityManager.createQuery("Select a from ApiKey" , GoogleApiKey.class).getResultList().stream().findFirst().orElse(new GoogleApiKey());
	}
	
}
