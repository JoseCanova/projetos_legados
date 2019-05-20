package br.com.valid.bio.agreement.exception.http;

import org.springframework.integration.channel.PublishSubscribeChannel;

public abstract class ErrorChannelHandler extends AbstractHttpErrorHandler {

	protected PublishSubscribeChannel errorChannel;

	public ErrorChannelHandler() {
	}

	public ErrorChannelHandler(PublishSubscribeChannel ec) {
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

	public PublishSubscribeChannel getErrorChannel() {
		return errorChannel;
	}
}
