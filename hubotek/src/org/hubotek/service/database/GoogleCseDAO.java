package org.hubotek.service.database;

import org.hubotek.model.cse.GoogleSearchEngineBase;
import org.springframework.stereotype.Service;

@Service
public class GoogleCseDAO extends BaseDAO<String , GoogleSearchEngineBase>{

	public GoogleSearchEngineBase findById(String id)
	{ 
		return findById(GoogleSearchEngineBase.class , id);
	}
	
}
