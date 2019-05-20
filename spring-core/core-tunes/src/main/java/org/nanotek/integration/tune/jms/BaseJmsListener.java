package org.nanotek.integration.tune.jms;

import org.apache.log4j.Logger;
import org.nanotek.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
public class BaseJmsListener implements Base<Long> {

	private Logger logger  = Logger.getLogger(BaseJmsListener.class);
	
	private Long id; 

	/**
	 * Get a copy of the application context
	 */
	@Autowired
	ConfigurableApplicationContext context;

	public BaseJmsListener() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id=id;
	}

	/**
	 * When you receive a message, print it out, then shut down the application.
	 * Finally, clean up any ActiveMQ server stuff.
	 */
	@JmsListener(destination = "ARTIST_QUEUE", containerFactory = "connectionFactory")
	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
	}

}
