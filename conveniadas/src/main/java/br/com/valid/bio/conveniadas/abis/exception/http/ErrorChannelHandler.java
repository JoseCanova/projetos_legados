package br.com.valid.bio.conveniadas.abis.exception.http;

import org.springframework.messaging.MessageChannel;

public abstract class ErrorChannelHandler extends AbstractHttpErrorHandler {

	protected MessageChannel errorChannel;

	public ErrorChannelHandler() {
	}

	public ErrorChannelHandler(MessageChannel ec) {
		this.errorChannel = ec;
	}

	@Override
	public void handleError(Throwable t) {
		try {
			getMessagingTemplate().send(getErrorChannel(), getErrorMessageStrategy().buildErrorMessage(t, null));
		}
		catch (Throwable errorDeliveryError) { //NOSONAR
			if (this.logger.isWarnEnabled()) {
				this.logger.warn("Error message was not delivered.", errorDeliveryError);
			}
			if (errorDeliveryError instanceof Error) {
				throw ((Error) errorDeliveryError);
			}
			throw errorDeliveryError;
		}
	}

	public MessageChannel getErrorChannel() {
		return errorChannel;
	}
}
