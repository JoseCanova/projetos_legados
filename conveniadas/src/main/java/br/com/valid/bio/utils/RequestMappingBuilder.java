package br.com.valid.bio.utils;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.integration.http.inbound.RequestMapping;

/**
 * Helper class de configuracao endpoints rest conveniadas.
 * 
 * @author jose.canova
 *
 */
public class RequestMappingBuilder {

	private RequestMapping mapping;

	public RequestMappingBuilder() { 
		mapping = new RequestMapping();
	}
	
	public RequestMappingBuilder(RequestMapping mapping) 
	{
			this.mapping = mapping;
	}

	public RequestMappingBuilder withMethods(HttpMethod... methods) { 
		mapping.setMethods(methods);
		return this;
	}
	
	public RequestMappingBuilder consumes(String... mediaTypes) { 
		mapping.setConsumes(mediaTypes);
		return this;
	}
	
	public RequestMappingBuilder produces(String... mediaTypes) { 
		mapping.setProduces(mediaTypes);
		return this;
	}
	
	public RequestMappingBuilder withPathPatterns(String... pathPatterns) { 
		mapping.setPathPatterns(pathPatterns);
		return this;
	}
	
	public RequestMappingBuilder consumingProducingJson() { 
		mapping.setConsumes(MediaType.APPLICATION_JSON_VALUE);
		mapping.setProduces(MediaType.APPLICATION_JSON_VALUE);
		return this;
	}
	
	public RequestMapping build() { 
		return mapping;
	}
	
}
