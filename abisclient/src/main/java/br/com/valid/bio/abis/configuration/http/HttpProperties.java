package br.com.valid.bio.abis.configuration.http;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="http")
public class HttpProperties {

	private String endPoint;
	
	private String enrollEndPoint;
	
	public HttpProperties() {
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getEnrollEndPoint() {
		return enrollEndPoint;
	}

	public void setEnrollEndPoint(String enrollEndPoint) {
		this.enrollEndPoint = enrollEndPoint;
	}

}
