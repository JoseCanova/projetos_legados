package org.nanotek.apachemq.listener;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.validation.Valid;

import org.apache.activemq.command.ActiveMQBytesMessage;
import org.nanotek.Base;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.service.dispatcher.EntityDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.validation.annotation.Validated;

import com.google.gson.Gson;

@Validated
public abstract class BaseBeanJmsListener <K extends Base,I extends Base> implements SessionAwareMessageListener<ActiveMQBytesMessage>{
    
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
			K bean = MessageListenerHelper.processMessage(message, getGson(), getClazz());
			dispatch(bean);
		}catch (Exception ex) { 
			log.error("error processing message pipeline", ex);
		}
	}

	private void dispatch(@Valid K bean) {
		I result = getDispatcher().transform(bean);
		getDispatcher().dispatch(result);
	}

	protected abstract EntityDispatcher<K,I> getDispatcher();
	
	protected Gson getGson() {
		return gson;
	}
	
	protected abstract Class<K> getClazz();

}
