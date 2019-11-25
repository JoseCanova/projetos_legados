package org.nanotek.apachemq;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.nanotek.apachemq.listener.ArtistCreditNameBeanJmsListener;
import org.nanotek.apachemq.listener.JmsListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@Configuration
public class ApacheMqConfiguration {

	@Bean
	@Qualifier(value="releaseQueue")
	public Queue queue() {
		return new ActiveMQQueue("musicbrainz.queue");
	}

	@Bean
	@Qualifier(value="baseQueue")
	public Queue baseQueue() {
		return new ActiveMQQueue("musicbrainz.basequeue");
	}

	@Bean 
	public MappingJackson2MessageConverter jsonConverter() { 
		MappingJackson2MessageConverter mc = new MappingJackson2MessageConverter();
		mc.setPrettyPrint(true);
		return mc;
	}

	@Bean
	public JmsMessagingTemplate jmsMessagingTemplate(@Autowired ConnectionFactory connectionFactory) { 
		JmsMessagingTemplate jmsMessagingTemplate = new JmsMessagingTemplate(connectionFactory);
		jmsMessagingTemplate.setMessageConverter(jsonConverter());
		return jmsMessagingTemplate;
	}

	//	<bean id = "messageListenerContainer" class="org.springframework.jms.listener.DefaultMessageListenerContainer">
	//    <property name="connectionFactory" ref="connectionFactory"/>
	//    <property name="destinationName" value="Send2Recv"/>
	//    <property name="messageListener" ref="jmsMessageListener"/>
	//  </bean>

	@Bean
	public DefaultMessageListenerContainer listenerContainer(@Autowired ConnectionFactory connectionFactory , @Autowired JmsListener jmsListener ) { 
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setMaxConcurrentConsumers(10);
		container.setDestinationName("musicbrainz.queue");
		container.setMessageListener(jmsListener);
		return container;
	}

	@Bean
	public DefaultMessageListenerContainer listenerContainer2(@Autowired ConnectionFactory connectionFactory , @Autowired ArtistCreditNameBeanJmsListener jmsListener ) { 
		DefaultMessageListenerContainer a = new DefaultMessageListenerContainer();
		a.setMaxConcurrentConsumers(1);
		a.setDestinationName("musicbrainz.basequeue");
		a.setConnectionFactory(connectionFactory);
		a.setMessageListener(jmsListener);
		return a;
	}


}
