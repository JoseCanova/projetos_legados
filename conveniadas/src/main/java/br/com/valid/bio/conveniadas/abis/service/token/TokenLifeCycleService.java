package br.com.valid.bio.conveniadas.abis.service.token;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;

import br.com.valid.bio.conveniadas.abis.configuration.channel.ChannelConfiguration;
import br.com.valid.bio.conveniadas.abis.configuration.dispatcher.DispatcherProperties;
import br.com.valid.bio.conveniadas.abis.exception.AbisRuntimeException;
import br.com.valid.bio.conveniadas.model.AgreementRequest;
import br.com.valid.bio.conveniadas.model.OauthTokenData;

/**
 * 
 * Proposito, gerenciar a registrar o token requisitado pelo OAUTH Valid.
 * Transfere o token registrado para o canal que despacha a requisição para o abis. 
 * Senão, despacha a mensagem para canal de requisição do token. que retorna o token autenticado 
 * para o serviço. 
 * 
 * O Bean ´executado a primeira vez durante após a inicialização do container onde efetua o ciclo de autenticação OAUTH Abis.
 *
 * @author jose.canova
 *
 */
@MessageEndpoint
@Order(1)
public class TokenLifeCycleService implements InitializingBean , ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(TokenLifeCycleService.class);
	
	private OauthTokenData tokenData;
	
	private static final long TOKEN_RENEW_INTERVAL_SECONDS = 3100;
	
	@Autowired
	private ChannelConfiguration channelConfiguration;
	
	@Autowired 
	private DispatcherProperties dispatcherProperties;
	
	private boolean tokenValid;
	
	private boolean scheduled;
	
	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;
	
	
	//TODO:implementar rotina para casos de erro na recuperação do token.
	@ServiceActivator
	public void checkForTokenExpired(Message<AgreementRequest> requestMessage) {
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("After Properties Set");
		tokenValid = false;
		scheduled = false;
	}

	public boolean isTokenValid() { 
		return tokenValid;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("run " + args.toString());
		requestToken();
	}
	
	private void requestToken() { 
		new MessagingTemplate().convertAndSend(channelConfiguration.accessTokenChannel(), dispatcherProperties.getTokenParameters());
	}
	
	@ServiceActivator(inputChannel="accessTokenOutputChannel")
	public void processToken(Message<OauthTokenData> tokenMessage) { 
		logger.info(tokenMessage.toString());
		this.tokenData = tokenMessage.getPayload();
		tokenValid = true;
		if(!scheduled) { 
		threadPoolTaskScheduler.schedule(new Runnable() {
				@Override
				public void run() {
					tokenValid = false;
					requestToken();
				}
			}, new PeriodicTrigger(TOKEN_RENEW_INTERVAL_SECONDS, TimeUnit.SECONDS));
			scheduled = true;
		}
		
	}

	//TODO: Exceção foi colocada para configuração e teste da trigger de renovação do token.
	//TODO: implementar uma exceção para token invalido.
	public OauthTokenData getTokenData() {
		if (tokenValid) {
			return tokenData;
		}
		throw new AbisRuntimeException("Token Not Valid");
	}
	
	
	
}
