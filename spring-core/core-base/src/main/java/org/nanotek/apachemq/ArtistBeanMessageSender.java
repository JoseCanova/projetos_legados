package org.nanotek.apachemq;

import java.util.concurrent.Future;

import javax.jms.Queue;

import org.nanotek.beans.csv.ArtistBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class ArtistBeanMessageSender extends JmsMessageSender<ArtistBean> {

	public ArtistBeanMessageSender(@Autowired JmsMessagingTemplate jmsTemplate ,
										@Autowired @Qualifier("artistNameQueue")Queue queue) {
		super(jmsTemplate,queue);
	}

	@Async("threadPoolTaskExecutor")
	public Future<ArtistBean> sendAsync(ArtistBean ab) {
		return new AsyncResult<ArtistBean> (send(ab));
	}

	@Override
	public ArtistBean send (ArtistBean message) {
		return super.send(message);
	}

}
