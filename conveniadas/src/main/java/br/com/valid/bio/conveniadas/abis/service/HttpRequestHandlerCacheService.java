package br.com.valid.bio.conveniadas.abis.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.stereotype.Component;

@Component
public class HttpRequestHandlerCacheService {

	private Map<String,HttpRequestExecutingMessageHandler> handlerCache;
	
	public HttpRequestHandlerCacheService() {
	}
	
	@PostConstruct
	private void postConstruct() { 
		handlerCache = new HashMap<>();
	}

	public boolean containsKey(String key) {
		return handlerCache.containsKey(key);
	}
	
	public boolean containsValue(HttpRequestExecutingMessageHandler value) {
		return handlerCache.containsValue(value);
	}

	public HttpRequestExecutingMessageHandler get(String key) {
		return handlerCache.get(key);
	}

	public HttpRequestExecutingMessageHandler put(String key, HttpRequestExecutingMessageHandler value) {
		return handlerCache.put(key, value);
	}

	public void clear() {
		handlerCache.clear();
	}

	public Set<String> keySet() {
		return handlerCache.keySet();
	}

	public  HttpRequestExecutingMessageHandler getOrDefault(String key, HttpRequestExecutingMessageHandler defaultValue) {
		return handlerCache.getOrDefault(key, defaultValue);
	}

	public  HttpRequestExecutingMessageHandler putIfAbsent(String key, HttpRequestExecutingMessageHandler value) {
		return handlerCache.putIfAbsent(key, value);
	}

}
