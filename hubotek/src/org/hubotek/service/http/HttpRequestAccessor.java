package org.hubotek.service.http;

import java.net.URI;

import org.hubotek.HubotekException;
import org.hubotek.google.news.feed.DomParser;
import org.hubotek.http.ResponseCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

@Service
public class HttpRequestAccessor extends HttpAccessor{

	public Boolean isHttpClient = false;
	
	@Autowired
	protected DomParser parser;

	public HttpRequestAccessor()
	{ 
		super();
	}
	
	public Boolean getIsHttpClient() {
		return isHttpClient;
	}

	public void setIsHttpClient(Boolean isHttpClient) {
		this.isHttpClient = isHttpClient;
	}
	
	public Document processRequest(String location) 
	{ 
		ClientHttpRequest request;
		ClientHttpResponse response = null;
		Document document;
		try { 
		request = this.createRequest(new URI(location), HttpMethod.GET);
		response = request.execute();
		document = parser.parseInput(new InputSource(response.getBody()));
		}catch (Exception e)
		{ 
			throw new HubotekException(e);
		}
		return document;
	}
	
	public Document doRequest(String location, ResponseCallback callback)
	{ 
		return processRequest(location);
	}
	
}
