package br.com.valid.bio.agreement.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="mongo")
public class MongoProperties {

	private String uri;
	
	private int port;
	
	private String databaseName;
	
	private Channels channels;
	
	public MongoProperties() {}
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public Channels channels() {
		return channels;
	}
	
	public Channels getChannels() {
		return channels;
	}

	public void setChannels(Channels channels) {
		this.channels = channels;
	}
	
	public static class Channels { 
		
		private String inputChannel; 
		
		private String outputChannel;

		private String messageRetrieveInputChannel;
		
		private String messageRetrieveOutputChannel;
		
		private String errorMessageHandlerChannel;
		
		
		public String getInputChannel() {
			return inputChannel;
		}


		public void setInputChannel(String inputChannel) {
			this.inputChannel = inputChannel;
		}

		public String getOutputChannel() {
			return outputChannel;
		}

		public void setOutputChannel(String outputChannel) {
			this.outputChannel = outputChannel;
		}
		

		public String getMessageRetrieveInputChannel() {
			return messageRetrieveInputChannel;
		}


		public void setMessageRetrieveInputChannel(String messageRetrieveInputChannel) {
			this.messageRetrieveInputChannel = messageRetrieveInputChannel;
		}


		public String getMessageRetrieveOutputChannel() {
			return messageRetrieveOutputChannel;
		}


		public void setMessageRetrieveOutputChannel(String messageRetrieveOutputChannel) {
			this.messageRetrieveOutputChannel = messageRetrieveOutputChannel;
		}


		public String getErrorMessageHandlerChannel() {
			return errorMessageHandlerChannel;
		}


		public void setErrorMessageHandlerChannel(String errorMessageHandlerChannel) {
			this.errorMessageHandlerChannel = errorMessageHandlerChannel;
		}
		
	}

}
