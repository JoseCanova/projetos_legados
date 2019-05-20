package br.com.valid.bio.conveniadas.abis.configuration.channel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.BridgeFrom;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.ErrorHandler;

@Configuration
public class ChannelConfiguration {

	@Autowired
	private ChannelProperties channelProperties;

	@Autowired
	@Qualifier("highPriorityThreadPoolExecutor")
	private ThreadPoolTaskExecutor highPriorityThreadPoolExecutor;
	
	@Autowired
	@Qualifier("normalPriorityThreadPoolExecutor")
	private ThreadPoolTaskExecutor normalPriorityThreadPoolExecutor;

	@Autowired
	@Qualifier("lowPriorityThreadPoolExecutor")
	private ThreadPoolTaskExecutor lowPriorityThreadPoolExecutor;

	
	@Autowired
	private List<ChannelInterceptor> interceptors;

	@Autowired 
	@Qualifier("abisHttpErrorChannelHandler")
	private ErrorHandler abisHttpErrorChannelHandler;
	
	public ChannelConfiguration() {
	}

	@Bean(name="mainInputChannel")
	@Qualifier(value="mainInputChannel")
	public MessageChannel mainInputChannel() { 
		PublishSubscribeChannel psc =  MessageChannels
										.publishSubscribe(channelProperties.getMainInputChannel(), highPriorityThreadPoolExecutor)
										.get();
		psc.setInterceptors(interceptors);
		return psc;
	}

	@Bean(name="mainOutputChannel")
	@Qualifier(value="mainOutputChannel")
	public MessageChannel mainOutputChannel() { 
		PublishSubscribeChannel psc =  MessageChannels
										.publishSubscribe(channelProperties.getMainOutputChannel(), highPriorityThreadPoolExecutor)
										.get();
//		psc.setInterceptors(interceptors);
		return psc;
	}
	
	
	@BridgeFrom("responseErrorOutputChannel")
	@Bean(name="prepareResponseChannel")
	@Qualifier(value="prepareResponseChannel")
	public MessageChannel prepareResponseChannel() { 
		PublishSubscribeChannel psc =  MessageChannels
										.publishSubscribe(channelProperties.getPrepareResponseChannel(), highPriorityThreadPoolExecutor)
										.get();
		psc.setInterceptors(interceptors);
		return psc;
	}

	@Bean(name="routeResponseChannel")
	@Qualifier(value="routeResponseChannel")
	public MessageChannel routeResponseChannel() { 
		PublishSubscribeChannel psc =  MessageChannels
										.publishSubscribe("routeResponseChannel", highPriorityThreadPoolExecutor)
										.get();
		psc.setInterceptors(interceptors);
		return psc;
	}
	
	@Bean(name="routeBaseResponseChannel")
	@Qualifier(value="routeBaseResponseChannel")
	public MessageChannel routeBaseResponseChannel() { 
		PublishSubscribeChannel psc =  MessageChannels
										.publishSubscribe("routeBaseResponseChannel", highPriorityThreadPoolExecutor)
										.get();
		psc.setInterceptors(interceptors);
		return psc;
	}
	
	@Bean(name="routeSubjectResponseChannel")
	@Qualifier(value="routeSubjectResponseChannel")
	public MessageChannel routeSubjectResponseChannel() { 
		PublishSubscribeChannel psc =  MessageChannels
										.publishSubscribe("routeSubjectResponseChannel", highPriorityThreadPoolExecutor)
										.get();
		psc.setInterceptors(interceptors);
		return psc;
	}
	
	//Bridge substituido pelo Service Activator que inicializa a transacao do servico.
//	@BridgeFrom("mainInputChannel")
	@Bean(name="messageEnricherInputChannel")
	@Qualifier(value="messageEnricherInputChannel")
	public MessageChannel messageEnricherInputChannel() { 
		PublishSubscribeChannel psc =  MessageChannels
										.publishSubscribe(channelProperties.getMessageEnricherInputChannel(), lowPriorityThreadPoolExecutor)
										.get();
		return psc;
	}
	
	@Bean(name="messageEnricherOutputChannel")
	@Qualifier(value="messageEnricherOutputChannel")
	public MessageChannel messageEnricherOutputChannel() { 
		PublishSubscribeChannel psc =  MessageChannels
										.publishSubscribe(channelProperties.getMessageEnricherOutputChannel(), highPriorityThreadPoolExecutor)
										.get();
		psc.setInterceptors(interceptors);
		return psc;
	}
	
//	@BridgeFrom("mongoOutputChannel")
	@Bean(name="mainHttpRequestChannel")
	@Qualifier(value="mainHttpRequestChannel")
	public MessageChannel mainHttpRequestChannel() { 
		PublishSubscribeChannel psc =  MessageChannels
										.publishSubscribe(channelProperties.getMainHttpRequestChannel(), lowPriorityThreadPoolExecutor)
										.get();
		psc.setInterceptors(interceptors);
		psc.setErrorHandler(abisHttpErrorChannelHandler);
		return psc;
	}
	
	@Bean(name="mainHttpResponseChannel")
	@Qualifier(value="mainHttpResponseChannel")
	public MessageChannel mainHttpResponseChannel() { 
		PublishSubscribeChannel psc =  MessageChannels
										.publishSubscribe(channelProperties.getMainHttpResponseChannel(), highPriorityThreadPoolExecutor)
										.get();
		return psc;
	}
	
	@BridgeFrom("messageEnricherOutputChannel")
	@Bean(name="mongoInputChannel")
	@Qualifier(value="mongoInputChannel")
	public MessageChannel mongoInputChannel() { 
		PublishSubscribeChannel psc =  MessageChannels
										.publishSubscribe("mongoInputChannel", lowPriorityThreadPoolExecutor)
										.get();
		return psc;
	}
	
	@Bean(name="mongoOutputChannel")
	@Qualifier(value="mongoOutputChannel")
	public MessageChannel mongoOutputChannel() { 
		PublishSubscribeChannel psc =  MessageChannels
										.publishSubscribe("mongoOutputChannel", highPriorityThreadPoolExecutor)
										.get();
		psc.setInterceptors(interceptors);
		return psc;
	}
	
	@Bean(name="rabbitOutputChannel")
	@Qualifier(value="rabbitOutputChannel")
	public MessageChannel rabbitOutputChannel() { 
		PublishSubscribeChannel psc =  MessageChannels
										.publishSubscribe("rabbitOutputChannel", highPriorityThreadPoolExecutor)
										.get();
		return psc;
	}
	
	
//	@BridgeFrom("mongoOutputChannel")
	@Bean(name="accessTokenChannel")
	@Qualifier(value="accessTokenChannel")
	public MessageChannel accessTokenChannel() { 
		PublishSubscribeChannel psc = MessageChannels
											.publishSubscribe("accessTokenChannel" , highPriorityThreadPoolExecutor)
											.get();
		return psc;
	}
	
	
	@Bean(name="accessTokenOutputChannel")
	@Qualifier(value="accessTokenOutputChannel")
	public MessageChannel accessTokenOutputChannel() { 
		PublishSubscribeChannel psc = MessageChannels
											.publishSubscribe("accessTokenOutputChannel" , highPriorityThreadPoolExecutor)
											.get();
		return psc;
	}
	
	@Bean
	@Qualifier("clientCredentialsChannel")
	public MessageChannel clientCredentialsChannel() { 
		PublishSubscribeChannel psc = MessageChannels
											.publishSubscribe("clientCredentialsChannel" , lowPriorityThreadPoolExecutor)
											.get();
		return psc;
	}
	
	
	@Bean
	@Qualifier("loggingChannel")
	public MessageChannel loggingChannel() { 
		PublishSubscribeChannel psc = MessageChannels
											.publishSubscribe("loggingChannel" , lowPriorityThreadPoolExecutor)
											.get();
		return psc;
	}
	
	@Bean(name="mqChannel")
	@Qualifier(value="mqChannel")
	public MessageChannel mqChannel() { 
		PublishSubscribeChannel psc =  MessageChannels
										.publishSubscribe("mqChannel", highPriorityThreadPoolExecutor)
										.get();
		return psc;
	}
	
	
	@Bean(name="httpAbisErrorMessageHandlerChannel")
	@Qualifier(value="httpAbisErrorMessageHandlerChannel")
	public MessageChannel httpAbisErrorMessageHandlerChannel() { 
		PublishSubscribeChannel psc = MessageChannels
											.publishSubscribe("httpAbisErrorMessageHandlerChannel" , highPriorityThreadPoolExecutor)
											.get();
		return psc;
	}
	
	@Bean(name="errorHandlerOutputChannel")
	@Qualifier(value="errorHandlerOutputChannel")
	public MessageChannel errorHandlerOutputChannel() { 
		PublishSubscribeChannel psc = MessageChannels
											.publishSubscribe("errorHandlerOutputChannel" , lowPriorityThreadPoolExecutor)
											.get();
		psc.setInterceptors(interceptors);
		return psc;
	}
	
	@Bean(name="responseErrorOutputChannel")
	@Qualifier(value="responseErrorOutputChannel")
	public MessageChannel responseErrorOutputChannel() { 
		PublishSubscribeChannel psc = MessageChannels
											.publishSubscribe("responseErrorOutputChannel" , highPriorityThreadPoolExecutor)
											.get();
		psc.setInterceptors(interceptors);
		return psc;
	}
	
	@Bean(name="transactionStateChannel")
	@Qualifier(value="transactionStateChannel")
	public MessageChannel transactionStateChannel() { 
		PublishSubscribeChannel psc = MessageChannels
											.publishSubscribe("transactionStateChannel" , highPriorityThreadPoolExecutor)
											.get();
		psc.setInterceptors(interceptors);
		return psc;
	}
	
	
	@Bean(name="transactionCanceledChannel")
	@Qualifier(value="transactionCanceledChannel")
	public MessageChannel transactionCanceledChannel() { 
		PublishSubscribeChannel psc = MessageChannels
											.publishSubscribe("transactionCanceledChannel" , highPriorityThreadPoolExecutor)
											.get();
		psc.setInterceptors(interceptors);
		return psc;
	}
	
	@Bean(name="emptyResponseDestinationChannel")
	@Qualifier(value="emptyResponseDestinationChannel")
	public MessageChannel emptyResponseDestinationChannel() { 
		PublishSubscribeChannel psc = MessageChannels
											.publishSubscribe("emptyResponseDestinationChannel" , highPriorityThreadPoolExecutor)
											.get();
		psc.setInterceptors(interceptors);
		return psc;
	}
	
	@Bean(name="poollerChannel")
	@Qualifier(value="poollerChannel")
	public MessageChannel poollerChannel() { 
		PublishSubscribeChannel psc = MessageChannels
											.publishSubscribe("poollerChannel" , highPriorityThreadPoolExecutor)
											.get();
		psc.setInterceptors(interceptors);
		return psc;
	}
	
	@Bean(name="timeOutCheckChannel")
	@Qualifier(value="timeOutCheckChannel")
	public MessageChannel timeOutCheckChannel() { 
		PublishSubscribeChannel psc = MessageChannels
											.publishSubscribe("timeOutCheckChannel" , highPriorityThreadPoolExecutor)
											.get();
		psc.setInterceptors(interceptors);
		return psc;
	}
	
	@Bean(name="mongoPoollerRequestChannel")
	@Qualifier(value="mongoPoollerRequestChannel")
	public MessageChannel mongoPoollerRequestChannel() { 
		PublishSubscribeChannel psc = MessageChannels
											.publishSubscribe("mongoPoollerRequestChannel" , highPriorityThreadPoolExecutor)
											.get();
		psc.setInterceptors(interceptors);
		return psc;
	}
	
	@Bean(name="mainEnrollDummyInputChannel")
	@Qualifier(value="mainEnrollDummyInputChannel")
	public MessageChannel mainEnrollDummyInputChannel() { 
		PublishSubscribeChannel psc = MessageChannels
											.publishSubscribe("mainEnrollDummyInputChannel" , lowPriorityThreadPoolExecutor)
											.get();
		return psc;
	}
	
	@Bean(name="mainEnrollDummyOutputChannel")
	@Qualifier(value="mainEnrollDummyOutputChannel")
	public MessageChannel mainEnrollDummyOutputChannel() { 
		PublishSubscribeChannel psc = MessageChannels
											.publishSubscribe("mainEnrollDummyInputChannel" , lowPriorityThreadPoolExecutor)
											.get();
		psc.setInterceptors(interceptors);
		return psc;
	}
	
}
