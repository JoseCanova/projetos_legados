package org.hubotek.google.search;

import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;
import org.hubotek.HubotekException;
import org.hubotek.model.atom.AtomDocument;
import org.hubotek.model.project.api.ApiKeyEnum;
import org.hubotek.service.database.GoogleApiKeyDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomSearchAdapter {

	private static final Logger logger = Logger.getLogger(CustomSearchAdapter.class);

	@Autowired 
	private GoogleApiKeyDAO googleApiKeyDAO; 
	
	public AtomDocument searchGoogle(@NotNull String query)
	{ 
		try { 
				GoogleSearchUrlBuilder googleSearchUrlBuilder = new GoogleSearchUrlBuilder(); 
				googleSearchUrlBuilder.withQuery(query).withKey(googleApiKeyDAO.findApiKeyByNameType("cse_generic", ApiKeyEnum.CUSTOM_SEARCH_KEY).getKey());
		}catch (Exception ex){ 
			throw new HubotekException (ex);
		}
		
		return null;
	}

}
