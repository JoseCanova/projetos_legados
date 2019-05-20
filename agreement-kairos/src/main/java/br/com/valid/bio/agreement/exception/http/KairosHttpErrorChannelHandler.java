package br.com.valid.bio.agreement.exception.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value="kairosHttpChannelErrorHandler")
public class KairosHttpErrorChannelHandler extends ErrorChannelHandler {

	public KairosHttpErrorChannelHandler(@Autowired 
										 @Qualifier("errorMessageHandlerChannel")
	 									 PublishSubscribeChannel ec) {
		super(ec);
	}
	
}
