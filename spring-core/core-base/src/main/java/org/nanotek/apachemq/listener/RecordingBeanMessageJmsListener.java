package org.nanotek.apachemq.listener;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.validation.Valid;

import org.apache.activemq.command.ActiveMQBytesMessage;
import org.nanotek.Transformer;
import org.nanotek.beans.Recording;
import org.nanotek.beans.csv.RecordingBean;
import org.nanotek.service.jpa.RecordingJpaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.google.gson.Gson;

@Service
@Validated
@Qualifier(value="RecordingBeanMessageJmsListener")
public class RecordingBeanMessageJmsListener implements SessionAwareMessageListener<ActiveMQBytesMessage>{

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private Gson gson;
	
	@Autowired
	@Qualifier("RecordingTransformer")
	private Transformer<RecordingBean,Recording> transformer;
	
	@Autowired
	private RecordingJpaService jpaService; 

	@Override
	public void onMessage(ActiveMQBytesMessage message, Session session) throws JMSException {
		try { 
			RecordingBean bean = MessageListenerHelper.processMessage(message, gson, RecordingBean.class);
			validateAndSave(bean);
		}catch (Exception ex) { 
			log.info(ex.getMessage());
		}
	}

	@Transactional
	private void validateAndSave(@Valid RecordingBean bean) {
		Recording recording = transformer.transform(bean);
		jpaService.save(recording);
	}
	
}
