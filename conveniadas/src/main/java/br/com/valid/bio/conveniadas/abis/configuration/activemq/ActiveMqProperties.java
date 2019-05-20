package br.com.valid.bio.conveniadas.abis.configuration.activemq;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value="mqProperties")
@ConfigurationProperties(prefix="mq")
public class ActiveMqProperties {

	private String brokerUrl;
	
	private int cacheSize;
	
	public ActiveMqProperties() {}
	
	public String getBrokerUrl() {
		return brokerUrl;
	}

	public void setBrokerUrl(String brokerUrl) {
		this.brokerUrl = brokerUrl;
	}

	public int getCacheSize() {
		return cacheSize;
	}

	public void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
	}
	
}
