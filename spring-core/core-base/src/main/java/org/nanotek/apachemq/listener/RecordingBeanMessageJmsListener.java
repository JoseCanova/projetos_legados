package org.nanotek.apachemq.listener;

import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQBytesMessage;
import org.nanotek.beans.Recording;
import org.nanotek.beans.csv.RecordingBean;
import org.nanotek.service.jpa.RecordingJpaService;
import org.nanotek.service.tranformer.RecordingTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class RecordingBeanMessageJmsListener implements SessionAwareMessageListener<ActiveMQBytesMessage>{

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private Gson gson;
	
	@Autowired
	private RecordingTransformer transformer;
	
	@Autowired
	private RecordingJpaService jpaService; 

	@Override
	public void onMessage(ActiveMQBytesMessage message, Session session) throws JMSException {
		RecordingBean bean = MessageListenerHelper.processMessage(message, gson, RecordingBean.class);
		if (valid(bean)) { 
			Recording recording = transformer.transform(bean);
			jpaService.save(recording);
		}
	}

	private boolean valid(RecordingBean bean) {
		return bean.getId() != null && bean.getName() !=null && bean.getArtistCredit() !=null;
	}
	
}
