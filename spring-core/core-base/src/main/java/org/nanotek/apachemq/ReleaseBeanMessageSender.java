package org.nanotek.apachemq;

import javax.jms.Queue;

import org.nanotek.beans.csv.ReleaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReleaseBeanMessageSender extends JmsMessageSender<ReleaseBean> {

	public ReleaseBeanMessageSender(@Autowired JmsMessagingTemplate jmsTemplate , 
									@Autowired @Qualifier("releaseQueue")Queue queue) { 
		super(jmsTemplate,queue);
	}
	
}
