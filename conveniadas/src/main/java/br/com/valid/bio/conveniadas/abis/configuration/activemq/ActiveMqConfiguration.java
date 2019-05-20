package br.com.valid.bio.conveniadas.abis.configuration.activemq;

import javax.jms.ConnectionFactory;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

@EnableJms
@Configuration
public class ActiveMqConfiguration {

	@Autowired
	@Qualifier("mqProperties")
	private ActiveMqProperties activeMqproperties;
	
	public ActiveMqConfiguration() {
	}

	@Bean
	@Qualifier(value="connectionFactory")
	public ActiveMQConnectionFactory  connectionFactory() { 
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(activeMqproperties.getBrokerUrl());
		return connectionFactory;
	}
	
	@Bean
	public CachingConnectionFactory cachingConnectionFactory(@Autowired  ActiveMQConnectionFactory  mqConnectionFactory) {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(mqConnectionFactory);
		cachingConnectionFactory.setSessionCacheSize(activeMqproperties.getCacheSize());
		return cachingConnectionFactory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate(@Autowired CachingConnectionFactory cachingConnectionFactory, 
									@Autowired @Qualifier("messageConverter")MappingJackson2MessageConverter messageConverter) { 
		JmsTemplate template = new JmsTemplate(cachingConnectionFactory);
		template.setDefaultDestinationName("AGREEMENT.TOPIC");
		template.setMessageConverter(messageConverter);
		return template;
	}
	
	@Bean
	public ActiveMQQueue destination() {
		return new ActiveMQQueue("AGREEMENT.TOPIC");
	}
	
	@Bean
	@Qualifier(value="jmsListenerContainerFactory")
    public JmsListenerContainerFactory<?> myFactory(@Autowired @Qualifier("connectionFactory") ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }
	
	@Bean
	@Qualifier(value="messageConverter")
	public MappingJackson2MessageConverter messageConverter() { 
		return new MappingJackson2MessageConverter();
	}
}
