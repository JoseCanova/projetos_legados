package br.com.valid.bio.conveniadas.abis.configuration.dispatcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("dispatcher")
public class DispatcherProperties {

	private  List<String> filterHeaderList = new ArrayList<>();
	
	private Map<String,String> tokenParameters = new HashMap<String,String>();
	
	public DispatcherProperties() {}

	public Map<String, String> getTokenParameters() {
		return tokenParameters;
	}

	public void setTokenParameters(Map<String, String> tokenParameters) {
		this.tokenParameters = tokenParameters;
	}

	public List<String> getFilterHeaderList() {
		return filterHeaderList;
	}

	public void setFilterHeaderList(List<String> filterHeaderList) {
		this.filterHeaderList = filterHeaderList;
	}
	
}
