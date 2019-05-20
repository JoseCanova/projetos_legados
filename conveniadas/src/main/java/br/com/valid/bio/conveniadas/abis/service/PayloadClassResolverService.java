package br.com.valid.bio.conveniadas.abis.service;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import br.com.valid.bio.conveniadas.abis.configuration.http.ClientEndpointConfiguration;
import br.com.valid.bio.conveniadas.abis.configuration.http.HttpProperties;

@Component
@DependsOn("httpProperties")
public class PayloadClassResolverService {

	@Autowired
	private HttpProperties httpProperties;

	private EndPointMap<String,Class<?>> endPointMap;

	public PayloadClassResolverService() {
	}

	@PostConstruct
	private void postConstruct() {
		endPointMap = new StaticEndPointMap<String,Class<?>>();
		prepareEndPointClassMap();
	}

	public Class<?> resolvePayloadClass(String key){
		return endPointMap.get(key); 
	}
	
	private void prepareEndPointClassMap() {
		httpProperties.getEndPoints().stream().forEach(m -> prepareAndPutEntry(m));
	}

	private void prepareAndPutEntry(ClientEndpointConfiguration m) {
		endPointMap.put(prepareEntry(m));
	}

	private Map.Entry<String,Class<?>> prepareEntry(ClientEndpointConfiguration m) {
		return  new AbstractMap.SimpleEntry<String,Class<?>>(m.getName(), m.getResponseClass());
	}

	/**
	 */
	public static interface EndPointMap<K,V> extends Map<K,V> {
		/**
		 * @param entry 
		 */
		public default V put(Entry<K,V> entry) {
			return put(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * An enhanced HashMap class.
	 */
	@SuppressWarnings("serial")
	public static class StaticEndPointMap<K,V> extends HashMap<K,V> implements EndPointMap<K,V> {}

}