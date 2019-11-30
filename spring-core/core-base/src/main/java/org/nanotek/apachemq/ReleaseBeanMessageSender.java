package org.nanotek.apachemq;

import java.util.concurrent.Future;

import javax.jms.Queue;

import org.nanotek.beans.csv.ReleaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class ReleaseBeanMessageSender extends JmsMessageSender<ReleaseBean> {

	public ReleaseBeanMessageSender(@Autowired JmsMessagingTemplate jmsTemplate , 
									@Autowired @Qualifier("releaseQueue")Queue queue) { 
		super(jmsTemplate,queue);
	}
	
	@Async
	public Future<ReleaseBean> sendAsync(ReleaseBean rb) { 
		return new AsyncResult<ReleaseBean> (send(rb));
	}
	
	@Override
	public ReleaseBean send (ReleaseBean message) { 
		return super.send(message);
	}
	
}
