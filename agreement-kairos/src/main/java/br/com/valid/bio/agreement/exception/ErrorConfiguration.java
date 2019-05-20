package br.com.valid.bio.agreement.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

import br.com.valid.bio.agreement.configuration.ChannelConfiguration;

@Configuration
public class ErrorConfiguration {

	
	/**
	 * Proposito
	 * Integration flow que redireciona para o canal mongo para saida de erro
	 * e efetua o log da mensagem.
	 * @return
	 */
	@Bean
	public IntegrationFlow errorHandlerFlow(@Autowired ChannelConfiguration channelConfiguration) { 
		return IntegrationFlows
					.from(channelConfiguration.errorHandlerOutputChannel())
					.channel(channelConfiguration.errorMessageHandlerChannel())
					.log()
					.get();
	}
	
}
