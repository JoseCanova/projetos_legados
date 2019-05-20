package org.hubotek.google.search;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.hubotek.Builder;

public class GoogleSearchUrlBuilder implements Builder<String>{
	
	private static final String baseUrlSearch = "https://www.googleapis.com/customsearch/v1"; 
	
	private static final Logger logger = Logger.getLogger(GoogleSearchUrlBuilder.class);
	
	private Map<SearchParameterEnum , String> parameters;
	
	public GoogleSearchUrlBuilder()
	{ 
		prepare();
	}
	
	private void prepare() {
		parameters = new EnumMap<SearchParameterEnum , String>(SearchParameterEnum.class);
	}


	public GoogleSearchUrlBuilder withCustomSearchId(String cxId)
	{ 
		parameters.put(SearchParameterEnum.CX_ID , cxId);
		return this;
	}
	
	public GoogleSearchUrlBuilder withKey(String key)
	{ 
		parameters.put(SearchParameterEnum.KEY, key);
		return this;
	}
	
	public GoogleSearchUrlBuilder withQuery(String query)
	{ 
		parameters.put(SearchParameterEnum.QUERY, query);
		return this;
	}
	
	public GoogleSearchUrlBuilder withAlt(String alt)
	{ 
		parameters.put(SearchParameterEnum.OUTPUT, alt);
		return this;
	}
	
	//TODO: validate parameters.
	public String build () 
	{ 
		String queryString = parameters.keySet().stream().flatMap(t->prepareParameter(t,parameters)).reduce(new BinaryOperator<String>(){
			@Override
			public String apply(String t, String u) {
				return t + "&" + u;
			}}).orElse("");
		logger.debug("The Query String : " + queryString);
		StringBuilder sb = new StringBuilder().append(baseUrlSearch);
		if (!queryString.isEmpty())
			sb.append("?").append(queryString).toString();
		return sb.toString();
	}

	private Stream<String> prepareParameter(SearchParameterEnum sp, Map<SearchParameterEnum, String> parameters) {
		return Arrays.asList(getQueryStringParameter(sp,parameters)).stream();
	}

	private String getQueryStringParameter(SearchParameterEnum sp,
			Map<SearchParameterEnum, String> parameters) {
		return sp.valueOf()+"="+parameters.get(sp);
	}
	
}
