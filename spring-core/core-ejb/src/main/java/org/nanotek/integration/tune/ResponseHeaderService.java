package org.nanotek.integration.tune;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component(value="responseHeaderService")
public class ResponseHeaderService {
	
	private Log log = LogFactory.getLog(ResponseHeaderService.class);
	
	@ServiceActivator
	public void handleMessage(Message<?> message) {

		log.debug(message.getPayload());
		
	}
}

