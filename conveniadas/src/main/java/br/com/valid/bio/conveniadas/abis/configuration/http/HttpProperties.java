package br.com.valid.bio.conveniadas.abis.configuration.http;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value="httpProperties")
@ConfigurationProperties(prefix="http")
public class HttpProperties {

	private String endPoint;
	
	private String enrollEndPoint;
	
	private List<ClientEndpointConfiguration> endPoints;
	
	private String abisClientScheme;
	
	private String abisClientUrl;
	
	public HttpProperties() {
	}

	public String getAbisClientScheme() {
		return abisClientScheme;
	}

	public String getAbisClientUrl() {
		return abisClientUrl;
	}

	public void setAbisClientUrl(String abisClientUrl) {
		this.abisClientUrl = abisClientUrl;
	}

	public void setAbisClientScheme(String abisClientScheme) {
		this.abisClientScheme = abisClientScheme;
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

	public List<ClientEndpointConfiguration> getEndPoints() {
		return endPoints;
	}

	public void setEndPoints(List<ClientEndpointConfiguration> endPoints) {
		this.endPoints = endPoints;
	}
}
