package br.com.valid.bio.abis.configuration.channel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ChannelConfiguration {

	@Autowired
	private ChannelProperties channelProperties;

	@Autowired
	@Qualifier("normalPriorityThreadPoolExecutor")
	private ThreadPoolTaskExecutor normalPriorityThreadPoolExecutor;

	@Autowired
	private List<ChannelInterceptor> interceptors;

	public ChannelConfiguration() {
	}

	@Bean
	@Qualifier(value="mainInputChannel")
	public MessageChannel mainInputChannel() { 
		PublishSubscribeChannel psc =  MessageChannels
										.publishSubscribe(channelProperties.getMainInputChannel(), normalPriorityThreadPoolExecutor)
										.get();
		psc.setInterceptors(interceptors);
		return psc;
	}

	@Bean
	@Qualifier(value="mainOutputChannel")
	public MessageChannel mainOutputChannel() { 
		PublishSubscribeChannel psc =  MessageChannels
										.publishSubscribe(channelProperties.getMainOutputChannel(), normalPriorityThreadPoolExecutor)
										.get();
		psc.setInterceptors(interceptors);
		return psc;
	}

	@Bean
	@Qualifier("loggingChannel")
	public MessageChannel loggingChannel() { 
		PublishSubscribeChannel psc = MessageChannels
				.publishSubscribe("loggingChannel" , normalPriorityThreadPoolExecutor)
				.get();
		psc.setInterceptors(interceptors);
		return psc;
	}
}
