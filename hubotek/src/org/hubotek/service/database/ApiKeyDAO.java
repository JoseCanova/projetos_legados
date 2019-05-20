package org.hubotek.service.database;

import java.util.List;

import org.hubotek.model.project.api.ApiKey;
import org.hubotek.model.project.api.ApiKeyEnum;
import org.hubotek.model.project.api.GoogleApiKey;
import org.springframework.stereotype.Service;

@Service
public class ApiKeyDAO extends BaseDAO<Long,ApiKey>{
	
	public ApiKey findById(Long id)
	{ 
		return findById(ApiKey.class, id);
	}
	
	public List<ApiKey> findApiKeyByType(ApiKeyEnum type)
	{ 
		return entityManager.createQuery("Select a from ApiKey where a.apiKeyType = :type" , ApiKey.class).setParameter("type", type) .getResultList();
	}
	
}
