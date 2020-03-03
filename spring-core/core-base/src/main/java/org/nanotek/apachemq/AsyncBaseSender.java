package org.nanotek.apachemq;

import java.util.concurrent.Future;

import javax.jms.Queue;

import org.nanotek.Base;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

public class AsyncBaseSender <K extends Base> extends JmsMessageSender<K> {

	public AsyncBaseSender(JmsMessagingTemplate jmsTemplate , Queue queue ) {
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
