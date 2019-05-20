package br.com.valid.bio.conveniadas.abis.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value="messageProperties")
@ConfigurationProperties(prefix="messages")
public class MessageProperties {

	private String badRequest;
	
	private String requestExpired;

	public String getBadRequest() {
		return badRequest;
	}

	public void setBadRequest(String badRequest) {
		this.badRequest = badRequest;
	}

	public String getRequestExpired() {
		return requestExpired;
	}

	public void setRequestExpired(String requestExpired) {
		this.requestExpired = requestExpired;
	}
	
}
