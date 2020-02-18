package org.nanotek.apachemq.listener;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.validation.Valid;

import org.apache.activemq.command.ActiveMQBytesMessage;
import org.nanotek.beans.Artist;
import org.nanotek.service.jpa.ArtistJpaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.google.gson.Gson;

@Service
@Validated
public class ArtistBeanJmsListener implements SessionAwareMessageListener<ActiveMQBytesMessage>{

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private Gson gson;

	@Autowired
	private ArtistJpaService ArtistJpaService;

	@Override
	@Async
	public void onMessage(ActiveMQBytesMessage message, Session session) throws JMSException {
		Artist Artist = MessageListenerHelper.processMessage(message, gson, Artist.class);
		try {
			validateAndSave(Artist);
		}catch (Exception ex) {
			log.info(ex.getMessage());
		}
	}

	@Transactional
	private void validateAndSave(@Valid Artist Artist) {
		ArtistJpaService.save(Artist);
	}
}
