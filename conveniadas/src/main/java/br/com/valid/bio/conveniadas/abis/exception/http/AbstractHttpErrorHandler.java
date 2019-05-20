package br.com.valid.bio.conveniadas.abis.exception.http;

import org.springframework.integration.support.ErrorMessagePublisher;
import org.springframework.messaging.MessageChannel;
import org.springframework.util.ErrorHandler;

public abstract class AbstractHttpErrorHandler extends ErrorMessagePublisher implements ErrorHandler {

	public AbstractHttpErrorHandler() {
	}
	
	public abstract MessageChannel getErrorChannel();

}
