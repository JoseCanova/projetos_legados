package org.nanotek.apachemq;

import java.util.concurrent.Future;

import javax.jms.Queue;

import org.nanotek.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class BaseBeanSender<K extends Base<?> , ID extends JmsMessageSender<K,ID>> extends JmsMessageSender<K> {

	public BaseBeanSender(@Autowired JmsMessagingTemplate jmsTemplate , @Autowired @Qualifier("baseQueue") Queue queue ) {
		super(jmsTemplate,queue);
	}
	
	@Async("threadPoolTaskExecutor")
	public Future<K> sendAsync(K rb) { 
		return new AsyncResult<K> (send(rb));
	}
	
	@Override
	public K send (K message) { 
		return super.send(message);
	}
}
