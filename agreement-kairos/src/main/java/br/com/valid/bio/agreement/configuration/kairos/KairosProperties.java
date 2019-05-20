package br.com.valid.bio.agreement.configuration.kairos;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="kairos")
public class KairosProperties {
	
	private String mappingEnroll; 
	
	private String mappingRecognize;
	
	private String mappgingVerify;
	
	private String appId; 
	
	private String appKey;
	
	private String enrollUrl; 
	
	private String recognizeUrl;
	
	private String verifyUrl;
	
	private Channels channels;
	
	public KairosProperties() {}

	public String getMappingEnroll() {
		return mappingEnroll;
	}

	public void setMappingEnroll(String mappingEnroll) {
		this.mappingEnroll = mappingEnroll;
	}

	public String getMappingRecognize() {
		return mappingRecognize;
	}

	public void setMappingRecognize(String mappingRecognize) {
		this.mappingRecognize = mappingRecognize;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public Channels getChannels() {
		return channels;
	}

	public void setChannels(Channels channels) {
		this.channels = channels;
	}
	
	public Channels channels() {
		return channels;
	}
	
	public String getEnrollUrl() {
		return enrollUrl;
	}

	public void setEnrollUrl(String enrollUrl) {
		this.enrollUrl = enrollUrl;
	}

	public String getRecognizeUrl() {
		return recognizeUrl;
	}

	public void setRecognizeUrl(String recognizeUrl) {
		this.recognizeUrl = recognizeUrl;
	}
	
	public String getVerifyUrl() {
		return verifyUrl;
	}

	public void setVerifyUrl(String verifyUrl) {
		this.verifyUrl = verifyUrl;
	}

	public String getMappgingVerify() {
		return mappgingVerify;
	}

	public void setMappgingVerify(String mappgingVerify) {
		this.mappgingVerify = mappgingVerify;
	}
	
	public static class Channels { 
		
		private String enrollChannel;
		
		private String recognizeChannel;
		
		private String verifyChannel;
		
		private String httpEnrollChannel;
		
		private String httpRecognizeChannel;
		
		private String httpVerifyChannel;
					   
		private String responseChannel;

		private String mainChannel;
		
		public Channels() {}

		public String getMainChannel() {
			return mainChannel;
		}

		public void setMainChannel(String mainChannel) {
			this.mainChannel = mainChannel;
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

		public String getHttpEnrollChannel() {
			return httpEnrollChannel;
		}

		public void setHttpEnrollChannel(String httpEnrollChannel) {
			this.httpEnrollChannel = httpEnrollChannel;
		}

		public String getHttpRecognizeChannel() {
			return httpRecognizeChannel;
		}

		public void setHttpRecognizeChannel(String httpRecognizeChannel) {
			this.httpRecognizeChannel = httpRecognizeChannel;
		}

		public String getResponseChannel() {
			return responseChannel;
		}

		public void setResponseChannel(String responseChannel) {
			this.responseChannel = responseChannel;
		}

		public String getHttpVerifyChannel() {
			return httpVerifyChannel;
		}

		public void setHttpVerifyChannel(String httpVerifyChannel) {
			this.httpVerifyChannel = httpVerifyChannel;
		}

		public String getVerifyChannel() {
			return verifyChannel;
		}

		public void setVerifyChannel(String verifyChannel) {
			this.verifyChannel = verifyChannel;
		}
		
	}
}
