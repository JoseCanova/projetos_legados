package org.nanotek.apachemq;

import javax.jms.Queue;

import org.nanotek.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class BaseBeanSender<K extends Base<?>> extends JmsMessageSender<K> {

	public BaseBeanSender(@Autowired JmsMessagingTemplate jmsTemplate , @Autowired @Qualifier("baseQueue") Queue queue ) {
		super(jmsTemplate,queue);
	}
	
}
