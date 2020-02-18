package org.nanotek.apachemq;

import java.util.concurrent.Future;
import javax.jms.Queue;
import org.nanotek.beans.ArtistName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class ArtistNameBeanMessageSender extends JmsMessageSender<ArtistName> {

	public ArtistNameBeanMessageSender(@Autowired JmsMessagingTemplate jmsTemplate ,
										@Autowired @Qualifier("artistNameQueue")Queue queue) {
		super(jmsTemplate,queue);
	}

	@Async("threadPoolTaskExecutor")
	public Future<ArtistName> sendAsync(ArtistName ab) {
		return new AsyncResult<ArtistName> (send(ab));
	}

	@Override
	public ArtistName send (ArtistName message) {
		return super.send(message);
	}

}
