package br.com.valid.bio.agreement.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="channels")
public class ChannelProperties {
	
	private String mainChannel;
	
	private String mainResponseChannel;

	private String agreementAggregatorChannel;
	
	private String enrollChannel; 
	
	private String recognizeChannel; 
	
	private String verifyChannel;
	
	private String errorHandlerOutputChannel;
	
	public ChannelProperties() {}

	public String getMainChannel() {
		return mainChannel;
	}

	public void setMainChannel(String mainChannel) {
		this.mainChannel = mainChannel;
	}

	public String getMainResponseChannel() {
		return mainResponseChannel;
	}

	public void setMainResponseChannel(String mainResponseChannel) {
		this.mainResponseChannel = mainResponseChannel;
	}

	public String getAgreementAggregatorChannel() {
		return agreementAggregatorChannel;
	}

	public void setAgreementAggregatorChannel(String agreementAggregatorChannel) {
		this.agreementAggregatorChannel = agreementAggregatorChannel;
	}

	public String getEnrollChannel() {
		return enrollChannel;
	}

	public void setEnrollChannel(String enrollChannel) {
		this.enrollChannel = enrollChannel;
	}

	public String getRecognizeChannel() {
		return recognizeChannel;
	}

	public void setRecognizeChannel(String recognizeChannel) {
		this.recognizeChannel = recognizeChannel;
	}

	public String getVerifyChannel() {
		return verifyChannel;
	}

	public void setVerifyChannel(String verifyChannel) {
		this.verifyChannel = verifyChannel;
	}

	public String getErrorHandlerOutputChannel() {
		return errorHandlerOutputChannel;
	}

	public void setErrorHandlerOutputChannel(String errorHandlerOutputChannel) {
		this.errorHandlerOutputChannel = errorHandlerOutputChannel;
	}

}
