package org.nanotek.apachemq;

import javax.jms.Queue;

import org.nanotek.Base;
import org.nanotek.Sender;
import org.springframework.jms.core.JmsMessagingTemplate;

public abstract class JmsMessageSender <K extends Base<?>>  implements Sender<K>{

	protected JmsMessagingTemplate jmsMessagingTemplate;
 
	protected Queue queue;
 
	public JmsMessageSender( JmsMessagingTemplate jmsMessagingTemplate , Queue queue ) { 
		this.jmsMessagingTemplate = jmsMessagingTemplate; 
		this.queue = queue;
	}
	
	public K send(K message){
		jmsMessagingTemplate.convertAndSend(this.queue, message);
		return message;
	}

	public JmsMessagingTemplate getJmsMessagingTemplate() {
		return jmsMessagingTemplate;
	}

	public void setJmsMessagingTemplate(JmsMessagingTemplate jmsMessagingTemplate) {
		this.jmsMessagingTemplate = jmsMessagingTemplate;
	}

	public Queue getQueue() {
		return queue;
	}

	public void setQueue(Queue queue) {
		this.queue = queue;
	}
	
	
	
}
