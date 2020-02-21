package org.nanotek.apachemq.listener;

import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQBytesMessage;
import org.nanotek.Base;
import org.nanotek.Mediator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;

import com.google.gson.Gson;

public abstract class BaseBeanJmsListener <K extends Base> implements SessionAwareMessageListener<ActiveMQBytesMessage>{
    
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired 
	Gson gson; 
	
	public BaseBeanJmsListener() {
	}
	
	@Override
	public void onMessage(ActiveMQBytesMessage message, Session session) throws JMSException {
		readAndDispatch(message,session);
	}

	private void readAndDispatch(ActiveMQBytesMessage message, Session session) {
		try { 
			K bean = MessageListenerHelper.processMessage(message, gson, getClazz());
			dispatch(bean);
		}catch (Exception ex) { 
			log.error("error processing message pipeline", ex);
		}
	}

	private void dispatch(K bean) {
		getMediator().mediate(bean);
	}

	protected abstract Mediator<K> getMediator();
	
	protected abstract Class<K> getClazz();

}
