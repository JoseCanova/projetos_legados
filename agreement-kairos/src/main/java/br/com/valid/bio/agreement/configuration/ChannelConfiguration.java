package br.com.valid.bio.agreement.configuration;

import br.com.valid.bio.agreement.configuration.kairos.KairosProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.BridgeFrom;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.ErrorHandler;

import java.util.List;

import static br.com.valid.bio.agreement.thread.ThreadPoolConfiguration.MONGO_MAX_CONNECTIONS;

@Configuration
@ConfigurationProperties
@ImportAutoConfiguration(RabbitAutoConfiguration.class)
public class ChannelConfiguration {

	
	private static final int MONGO_QUEUE_MAX_SIZE = MONGO_MAX_CONNECTIONS;
	
	
	@Autowired
	@Qualifier("normalPriorityThreadPoolExecutor")
	private ThreadPoolTaskExecutor normalPriorityThreadPoolExecutor;

	@Autowired
	@Qualifier("highPriorityThreadPoolExecutor")
	private ThreadPoolTaskExecutor highPriorityThreadPoolExecutor;

	@Autowired
	@Qualifier("lowPriorityThreadPoolExecutor")
	private ThreadPoolTaskExecutor lowPriorityThreadPoolExecutor;
	
	@Autowired
	@Qualifier("mongoLowPriorityThreadPoolExecutor")
	private ThreadPoolTaskExecutor mongoLowPriorityThreadPoolExecutor;
	
	@Autowired
	@Qualifier("mongoHighPriorityThreadPoolExecutor")
	private ThreadPoolTaskExecutor mongoHighPriorityThreadPoolExecutor;

	@Autowired
	private List<ChannelInterceptor> interceptors;

	@Autowired
	private KairosProperties kairosProperties;

	@Autowired
	private ChannelProperties channelProperties;

	@Autowired
	private MongoProperties mongoProperties;

	@Autowired
	@Qualifier("kairosHttpChannelErrorHandler")
	private ErrorHandler kairosHttpChannelErrorHandler;
	

	/**
	 * Canal de entrada da chamada REST agreement.
	 * 
	 * @return
	 */
	@Bean
	public PublishSubscribeChannel conveniadasChannel(){ 
		PublishSubscribeChannel psc= MessageChannels
				.publishSubscribe(channelProperties.getMainChannel() , normalPriorityThreadPoolExecutor)
				.get();
		psc.setInterceptors(interceptors);
		return psc;
	}

	@Bean
	public PublishSubscribeChannel agreementAggregatorChannel(){ 
		PublishSubscribeChannel psc= MessageChannels
				.publishSubscribe(channelProperties.getAgreementAggregatorChannel() , normalPriorityThreadPoolExecutor)
				.get();
		psc.setInterceptors(interceptors);
		return psc;
	}

	/**
	 * Canal de resposta da chamada REST agreement.
	 * 
	 * @return
	 */
	@Bean
	public PublishSubscribeChannel conveniadasResponseChannel(){ 
		PublishSubscribeChannel psc= MessageChannels
				.publishSubscribe(channelProperties.getMainResponseChannel() , normalPriorityThreadPoolExecutor)
				.get();
		psc.setInterceptors(interceptors);
		return psc;
	}

	/**
	 * Canal para mensagens de agreement que ainda nao foram cadastradas no sistema.
	 * @return
	 */
	@Bean("conveniadasDefaultRouterChannel")
	@Qualifier("conveniadasDefaultRouterChannel")
	public PublishSubscribeChannel conveniadasDefaultRouterChannel(){ 
		PublishSubscribeChannel psc= MessageChannels
				.publishSubscribe("conveniadasDefaultRouterChannel" , lowPriorityThreadPoolExecutor)
				.get();
		psc.setInterceptors(interceptors);
		return psc;
	}

	/**
	 * Canal para mensagens de agreement kairos enroll.
	 * TODO: analisar mudar a configuracao de Bridge do bean para o fluxo.
	 * @return

	@Bean
	@Qualifier(value="kairosEnrollChannel")
	@BridgeFrom("kairosHttpEnrollChannel")
	public PublishSubscribeChannel kairosEnrollChannel(){ 
		PublishSubscribeChannel mc = kairosChannelWithHandler();
		mc.setComponentName(kairosProperties.channels().getEnrollChannel());
		return mc;
	}*/

	@Bean
	public MessageChannel kairosEnrollChannel() {
		return new DirectChannel();
	}

	/**
	 * Canal para mensagens de agreement kairos enroll.
	 * @return
	 */
	@Bean
	public PublishSubscribeChannel kairosHttpEnrollChannel(){ 
		PublishSubscribeChannel psc= MessageChannels
									 .publishSubscribe(kairosProperties.channels().getHttpEnrollChannel() , normalPriorityThreadPoolExecutor)
									 .get();
		psc.setInterceptors(interceptors);
		return psc;
	}

	@Bean
	public PublishSubscribeChannel kairosHttpMainChannel(){
		PublishSubscribeChannel psc= MessageChannels
				.publishSubscribe(kairosProperties.channels().getMainChannel(), normalPriorityThreadPoolExecutor)
				.get();
		psc.setInterceptors(interceptors);
		return psc;
	}

	@Bean
	public MessageChannel enrollChannel() {
		return new DirectChannel();
	}

	@Bean
	public MessageChannel verifyChannel() {
		return new DirectChannel();
	}

	@Bean
	public MessageChannel recognizeChannel() {
		return new DirectChannel();
	}


	@Bean
	public PublishSubscribeChannel kairosHttpChannel(){
		PublishSubscribeChannel mc = kairosChannelWithHandler();
		mc.setComponentName(kairosProperties.channels().getMainChannel());
		return mc;
	}

	/**
	 * Canal para mensagens de agreement kairos recognize.
	 * @return
	 */
	@Bean
	@Qualifier(value="kairosRecognizeChannel")
	@BridgeFrom("kairosHttpRecognizeChannel")
	public PublishSubscribeChannel kairosRecognizeChannel(){ 
		PublishSubscribeChannel mc = kairosChannelWithHandler();
		mc.setComponentName(kairosProperties.channels().getRecognizeChannel());
		return mc;
	}

	/**
	 * Canal para mensagens de agreement kairos recognize.
	 * @return
	 */
	@Bean("kairosHttpRecognizeChannel")
	public PublishSubscribeChannel kairosHttpRecognizeChannel(){ 
		PublishSubscribeChannel psc= MessageChannels
									.publishSubscribe(kairosProperties.channels().getHttpRecognizeChannel() , normalPriorityThreadPoolExecutor)
									.get();
		psc.setInterceptors(interceptors);
		return psc;
	}


	@Bean
	@Qualifier(value="kairosVerifyChannel")
	@BridgeFrom("kairosHttpVerifyChannel")
	public PublishSubscribeChannel kairosVerifyChannel(){ 
		PublishSubscribeChannel mc = kairosChannelWithHandler();
		mc.setComponentName(kairosProperties.channels().getVerifyChannel());
		return mc;
	}

	
	private PublishSubscribeChannel kairosChannelWithHandler() {
		PublishSubscribeChannel psc = MessageChannels
				.publishSubscribe(highPriorityThreadPoolExecutor)
				.get();
		psc.setInterceptors(interceptors);
		psc.setErrorHandler(kairosHttpChannelErrorHandler);
		return psc;
	}
	
	/**
	 * Canal para mensagens de resposta chamada API Rest Kairos.
	 * Este é um canal comum do EndPoint Enroll Recognize.
	 * 
	 * @return
	 */
	@Bean
	public PublishSubscribeChannel kairosResponseChannel(){ 
		PublishSubscribeChannel psc= MessageChannels
				.publishSubscribe(kairosProperties.channels().getResponseChannel() , highPriorityThreadPoolExecutor)
				.get();
		psc.setInterceptors(interceptors);
		return psc;
	}

	/**
	 * Canal de entrada da chamada REST agreement.
	 * 
	 * @return
	 */
	@Bean(name="mongoInputChannel")
	@Qualifier("mongoInputChannel")
	public PublishSubscribeChannel mongoInputChannel(){ 
		PublishSubscribeChannel dc = MessageChannels
				.publishSubscribe(mongoProperties.getChannels().getInputChannel(), lowPriorityThreadPoolExecutor)
				.get();
		dc.setMaxSubscribers(MONGO_QUEUE_MAX_SIZE);
		dc.setInterceptors(interceptors);
		return dc;
	}

	@Bean(name="mongoOuputChannel")
	@Qualifier("mongoOuputChannel")
	public PublishSubscribeChannel mongoOutputChannel(){ 
		PublishSubscribeChannel psc = MessageChannels
				.publishSubscribe(mongoProperties.getChannels().getOutputChannel(), highPriorityThreadPoolExecutor)
				.get();
		psc.setInterceptors(interceptors);
		psc.setMaxSubscribers(MONGO_QUEUE_MAX_SIZE);
		return psc;
	}

	@Bean
	@Qualifier("routeRequestMessageChannel")
	public PublishSubscribeChannel routeRequestMessageChannel() { 
		PublishSubscribeChannel dc = MessageChannels
				.publishSubscribe("routeRequestMessageChannel", lowPriorityThreadPoolExecutor)
				.get();
		dc.setInterceptors(interceptors); 
		return dc;
	}

	@Bean(name="messageRetrieveInputChannel")
	@Qualifier("messageRetrieveInputChannel")
	public PublishSubscribeChannel messageRetrieveInputChannel(){ 
		PublishSubscribeChannel psc = MessageChannels
				.publishSubscribe(mongoProperties.getChannels().getMessageRetrieveInputChannel(), lowPriorityThreadPoolExecutor)
				.get();
		psc.setInterceptors(interceptors);
		psc.setMaxSubscribers(MONGO_QUEUE_MAX_SIZE);
		return psc;
	}

	@Bean(name="messageRetrieveOutputChannel")
	@Qualifier("messageRetrieveOutputChannel")
	public   PublishSubscribeChannel messageRetrieveOutputChannel(){ 
		PublishSubscribeChannel psc = MessageChannels
				.publishSubscribe(mongoProperties.getChannels().getMessageRetrieveOutputChannel(), highPriorityThreadPoolExecutor)
				.get();
		psc.setInterceptors(interceptors);
		psc.setMaxSubscribers(MONGO_QUEUE_MAX_SIZE);
		return psc;
	}


	@Bean(name="errorHandlerOutputChannel")
	@Qualifier(value="errorHandlerOutputChannel")
	public PublishSubscribeChannel errorHandlerOutputChannel() {
		PublishSubscribeChannel psc = MessageChannels
				.publishSubscribe(channelProperties.getErrorHandlerOutputChannel(), lowPriorityThreadPoolExecutor)
				.get();
		psc.setInterceptors(interceptors);
		psc.setMaxSubscribers(MONGO_QUEUE_MAX_SIZE);
		return psc;
	}
	
	/**
	 * Proposito Canal Mongo para recuperar mensagem de erro e retornar status de erro.
	 */
	@Bean(name="errorMessageHandlerChannel")
	@Qualifier(value="errorMessageHandlerChannel")
	public PublishSubscribeChannel errorMessageHandlerChannel() {
		PublishSubscribeChannel psc = MessageChannels
				.publishSubscribe(mongoProperties.channels().getErrorMessageHandlerChannel(), lowPriorityThreadPoolExecutor)
				.get();
		psc.setInterceptors(interceptors);
		psc.setMaxSubscribers(MONGO_QUEUE_MAX_SIZE);
		return psc;
	}


	@Bean
	public MessageChannel routerFlowChannel() {
		return new DirectChannel();
	}

	@Bean
	public MessageChannel kairosEnrollRouterFlowChannel() {
		return new DirectChannel();
	}

	@Bean
	public MessageChannel kairosVerifyRouterFlowChannel() {
		return new DirectChannel();
	}



}
