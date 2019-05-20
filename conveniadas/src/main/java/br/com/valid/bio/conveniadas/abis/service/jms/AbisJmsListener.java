package br.com.valid.bio.conveniadas.abis.service.jms;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Listener MQ para activeMQ.
 * @author jose.canova
 *
 */
//@Component
public class AbisJmsListener{

	private Logger logger  = LoggerFactory.getLogger(AbisJmsListener.class);
	
//	/**
//	 * Get a copy of the application context
//	 */
//	@Autowired
//	private ConfigurableApplicationContext context;

	public AbisJmsListener() {
	}

//	@JmsListener(destination = "AGREEMENT.TOPIC", containerFactory = "jmsListenerContainerFactory")
//	public void receiveMessage(String message) {
//		logger.debug("Received <" + message + ">");
//	}

}