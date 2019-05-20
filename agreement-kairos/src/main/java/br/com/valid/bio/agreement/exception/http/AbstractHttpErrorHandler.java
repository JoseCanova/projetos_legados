package br.com.valid.bio.agreement.exception.http;

import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.support.ErrorMessagePublisher;
import org.springframework.util.ErrorHandler;

public abstract class AbstractHttpErrorHandler extends ErrorMessagePublisher implements ErrorHandler {

	public AbstractHttpErrorHandler() {
	}
	
	public abstract PublishSubscribeChannel getErrorChannel();

}
