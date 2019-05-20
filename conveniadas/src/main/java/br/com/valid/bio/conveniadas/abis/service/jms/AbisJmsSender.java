package br.com.valid.bio.conveniadas.abis.service.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@MessageEndpoint
public class AbisJmsSender {

	private final JmsTemplate jmsTemplate;

	@Autowired
	public AbisJmsSender(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@ServiceActivator(inputChannel="mqChannel" , outputChannel="accessTokenChannel")
	public <T> Message<T> sendMessage(Message<T> message) { 
		T payload = message.getPayload();
		jmsTemplate.convertAndSend(payload);
		return MessageBuilder.withPayload(payload).copyHeaders(message.getHeaders()).build();
	}
		
}