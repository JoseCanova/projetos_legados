package br.com.valid.bio.agreement.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import br.com.valid.bio.agreement.configuration.ChannelConfiguration;
import br.com.valid.bio.agreement.configuration.cache.CacheProperties;

@MessageEndpoint
public class CacheService {

	@Autowired
	ChannelConfiguration channelConfiguration;
	
	@Autowired
	CacheProperties cacheProperties;
	
	@ServiceActivator
	public void agreementCacheService() { 
	}
	
}
