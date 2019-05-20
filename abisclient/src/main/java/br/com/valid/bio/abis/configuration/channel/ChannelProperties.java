package br.com.valid.bio.abis.configuration.channel;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="channel")
public class ChannelProperties {

	private String mainInputChannel;
	
	private String mainOutputChannel;
	
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

}
