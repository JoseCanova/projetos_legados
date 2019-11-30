package org.nanotek.apachemq;

import java.util.concurrent.Future;

import javax.jms.Queue;

import org.nanotek.beans.csv.RecordingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class RecordingBeanMessageSender extends JmsMessageSender<RecordingBean> {

	public RecordingBeanMessageSender(@Autowired JmsMessagingTemplate jmsTemplate , 
										@Autowired @Qualifier("recordingQueue")Queue queue) { 
		super(jmsTemplate,queue);
	}
	
	@Async
	public Future<RecordingBean> sendAsync(RecordingBean rb) { 
		return new AsyncResult<RecordingBean> (send(rb));
	}
	
	@Override
	public RecordingBean send (RecordingBean message) { 
		return super.send(message);
	}
	
}
