package br.com.valid.bio.conveniadas.abis.configuration.http;

import java.util.List;

import br.com.valid.bio.conveniadas.abis.service.transformers.Transformer;

/**
 * 
 * Propósito configurar os Endpoints de acesso para configurar 
 * o handler http que ira expor o serviço REST para o roteador
 * 
 * @author jose.canova
 *
 */
public class ClientEndpointConfiguration {

	private String name; 
	
	private String uri;
	
	private List<String> methods;
	
	private Class<?> responseClass;
	
	private int responseCode;
	
	private Class<?> requestClass;
	
	private Class<Transformer<?,?>> requestTransformer;
	
	private boolean allowPooling;
	
	public ClientEndpointConfiguration() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public List<String> getMethods() {
		return methods;
	}

	public void setMethods(List<String> methods) {
		this.methods = methods;
	}

	public Class<?> getResponseClass() {
		return responseClass;
	}

	public void setResponseClass(Class<?> responseClass) {
		this.responseClass = responseClass;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public Class<?> getRequestClass() {
		return requestClass;
	}

	public void setRequestClass(Class<?> requestClass) {
		this.requestClass = requestClass;
	}

	public Class<Transformer<?, ?>> getRequestTransformer() {
		return requestTransformer;
	}

	public void setRequestTransformer(Class<Transformer<?, ?>> requestTransformer) {
		this.requestTransformer = requestTransformer;
	}

	public boolean allowPooling() {
		return allowPooling;
	}

	public void setAllowPooling(boolean allowPooling) {
		this.allowPooling = allowPooling;
	}

	@Override
	public String toString() {
		return "ClientEndpointConfiguration [name=" + name + ", uri=" + uri + ", methods=" + methods
				+ ", responseClass=" + responseClass + ", responseCode=" + responseCode + ", requestClass="
				+ requestClass + ", requestTransformer=" + requestTransformer + ", allowPooling=" + allowPooling + "]";
	}
	
}
