package br.com.valid.bio.conveniadas.abis.service;

import org.springframework.stereotype.Component;

import br.com.valid.bio.conveniadas.model.OauthTokenData;

@Component
public class AuthorizationTokenBuilderService {

	public AuthorizationTokenBuilderService() {};
	
	public String prepareToken(OauthTokenData oau) { 
		return new StringBuilder().append(oau.getTokenType()).append(' ').append(oau.getAccessToken()).toString();
	}
}
