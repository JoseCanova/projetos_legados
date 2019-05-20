package org.hubotek.model.feed.inet;

import java.util.List;

public class WebAddress {

	private Long id; 
	
	private String baseUrl;
	
	private Boolean hasSecure; 
	
	public WebAddress(){}
	
	private List<WebAddress> feedAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public List<WebAddress> getFeedAddress() {
		return feedAddress;
	}

	public void setFeedAddress(List<WebAddress> feedAddress) {
		this.feedAddress = feedAddress;
	}
	
	public Boolean getHasSecure() {
		return hasSecure;
	}

	public void setHasSecure(Boolean hasSecure) {
		this.hasSecure = hasSecure;
	}
}
