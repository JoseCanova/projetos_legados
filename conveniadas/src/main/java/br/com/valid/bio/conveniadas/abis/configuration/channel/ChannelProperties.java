package br.com.valid.bio.conveniadas.abis.configuration.channel;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="channel")
public class ChannelProperties {

	private String mainInputChannel;
	
	private String mainOutputChannel;

	private String mainHttpRequestChannel;
	
	private String mainHttpResponseChannel;

	private String messageEnricherInputChannel;
	
	private String messageEnricherOutputChannel;
	
	private String prepareResponseChannel;
	
	public ChannelProperties() {
	}

	public String getMainInputChannel() {
		return mainInputChannel;
	}

	public void setMainInputChannel(String mainInputChannel) {
		this.mainInputChannel = mainInputChannel;
	}

	public String getMainOutputChannel() {
		return mainOutputChannel;
	}

	public void setMainOutputChannel(String mainOutputChannel) {
		this.mainOutputChannel = mainOutputChannel;
	}

	public String getMainHttpRequestChannel() {
		return mainHttpRequestChannel;
	}

	public void setMainHttpRequestChannel(String mainHttpRequestChannel) {
		this.mainHttpRequestChannel = mainHttpRequestChannel;
	}
	
	public String getMainHttpResponseChannel() {
		return mainHttpResponseChannel;
	}

	public void setMainHttpResponseChannel(String mainHttpResponseChannel) {
		this.mainHttpResponseChannel = mainHttpResponseChannel;
	}

	public String getMessageEnricherInputChannel() {
		return messageEnricherInputChannel;
	}

	public void setMessageEnricherInputChannel(String messageEnricherInputChannel) {
		this.messageEnricherInputChannel = messageEnricherInputChannel;
	}

	public String getMessageEnricherOutputChannel() {
		return messageEnricherOutputChannel;
	}

	public void setMessageEnricherOutputChannel(String messageEnricherOutputChannel) {
		this.messageEnricherOutputChannel = messageEnricherOutputChannel;
	}
	
	public String getPrepareResponseChannel() {
		return prepareResponseChannel;
	}

	public void setPrepareResponseChannel(String prepareResponseChannel) {
		this.prepareResponseChannel = prepareResponseChannel;
	}

}
