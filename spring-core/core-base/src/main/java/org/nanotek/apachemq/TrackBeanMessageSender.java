package org.nanotek.apachemq;

import java.util.concurrent.Future;

import javax.jms.Queue;

import org.nanotek.beans.csv.TrackBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class TrackBeanMessageSender extends JmsMessageSender<TrackBean> {

	public TrackBeanMessageSender(@Autowired JmsMessagingTemplate jmsMessagingTemplate,
									@Autowired @Qualifier("trackBeanQueue") Queue queue) {
		super(jmsMessagingTemplate, queue);
	}
	
	@Async("threadPoolTaskExecutor")
	public Future<TrackBean> sendAsync(TrackBean tb) { 
		return new AsyncResult<TrackBean> (send(tb));
	}
	
	@Override
	public TrackBean send (TrackBean message) { 
		return super.send(message);
	}

}
