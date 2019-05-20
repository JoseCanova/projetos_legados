package org.hubotek.google.news;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;

//TODO: create a validation filter for url parameters.
public class GoogleNewsUrlBuilder {

	String baseUrl = "https://news.google.com/news"; 
	private EnumMap<GoogleNewsUrlParametersEnum,String> urlParameterMap = new EnumMap<GoogleNewsUrlParametersEnum,String>(GoogleNewsUrlParametersEnum.class);
	
	public GoogleNewsUrlBuilder(){}
	
	public GoogleNewsUrlBuilder withLang(String lang){ 
		if (notEmpty(lang))
			put(GoogleNewsUrlParametersEnum.HL, lang);
		return this;
	}
	

	public GoogleNewsUrlBuilder withCode(String code)
	{ 
		if (notEmpty(code))
			put(GoogleNewsUrlParametersEnum.CODE, code);
		return this;
	}
	
	public GoogleNewsUrlBuilder withTopic(String topic)
	{ 
		if (notEmpty(topic))
			put(GoogleNewsUrlParametersEnum.TOPIC, topic);
		return this;
	}
	
	public GoogleNewsUrlBuilder withOutput(String output)
	{ 
		if (notEmpty(output))
			put(GoogleNewsUrlParametersEnum.OUTPUT, output);
		return this;
	}
	
	public GoogleNewsUrlBuilder withEdition(String edition)
	{ 
		if (notEmpty(edition))
			put(GoogleNewsUrlParametersEnum.NED, edition);
		return this;
	}
	
	public GoogleNewsUrlBuilder withQuery(String query)
	{ 
		if (notEmpty(query))
			put(GoogleNewsUrlParametersEnum.QUERY, query);
		return this;
	}
	
	public GoogleNewsUrlBuilder withScoring(String scoring) {
		if(notEmpty(scoring))
			put(GoogleNewsUrlParametersEnum.SCORING,scoring);
		return this;
	}
	
	//TODO: Check if resultCount format is a "numeric integer value"
	public GoogleNewsUrlBuilder withResultCount(String resultCount)
	{ 
		if (notEmpty(resultCount))
			put(GoogleNewsUrlParametersEnum.NUM, resultCount);
		return this;
	}
	
	//TODO: use the non deprecated method.
	@SuppressWarnings("deprecation")
	public GoogleNewsUrlBuilder withCity(String city) {
		if (notEmpty(city)){
			put(GoogleNewsUrlParametersEnum.CITY,URLEncoder.encode(city));
		}
		return this;
	}
	
	private void put(GoogleNewsUrlParametersEnum parameter , String value)
	{ 
		urlParameterMap.put(parameter, value);
	}
	
	private boolean notEmpty(String val)
	{ 
		return (val != null && val.length() > 0) ? true : false;
	}
	
	public List<String> prepareParameterList()
	{
		List<String> paramList = new ArrayList<String>();
		for (GoogleNewsUrlParametersEnum parameterKey : urlParameterMap.keySet())
		{
			StringBuilder param = new StringBuilder();
			param.append(parameterKey.getUrlParameter()).append("=").append(urlParameterMap.get(parameterKey));
			paramList.add(param.toString());
		}
		return paramList;
	}
	
	
	public String build()
	{ 
		StringBuilder sb = new StringBuilder();
		Iterator<String> parameterIterator = prepareParameterList().iterator();
		while(parameterIterator.hasNext())
		{ 
			sb.append(parameterIterator.next());
			if (parameterIterator.hasNext())
				sb.append('&');
		}
		sb.insert(0, baseUrl).insert(baseUrl.length(), '?');
		return sb.toString();
	}

}
