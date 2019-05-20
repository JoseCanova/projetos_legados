package br.com.valid.bio.conveniadas.abis.exception.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value="abisHttpErrorChannelHandler")
public class AbisHttpErrorChannelHandler extends ErrorChannelHandler {

	public AbisHttpErrorChannelHandler(@Autowired 
									   @Qualifier("httpAbisErrorMessageHandlerChannel") MessageChannel ec) {
		super(ec);
	}
	
}
