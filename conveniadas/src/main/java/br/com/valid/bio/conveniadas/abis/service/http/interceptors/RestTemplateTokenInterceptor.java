package br.com.valid.bio.conveniadas.abis.service.http.interceptors;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import br.com.valid.bio.conveniadas.abis.service.AuthorizationTokenBuilderService;
import br.com.valid.bio.conveniadas.model.OauthTokenData;

/**
 * @deprecated
 * @author jose.canova
 *
 */
public class RestTemplateTokenInterceptor implements ClientHttpRequestInterceptor {
	
	@Autowired
	private AuthorizationTokenBuilderService tokenBuilderService;
	
	private OauthTokenData oAuthToken;

	public RestTemplateTokenInterceptor() { 
		super();
	}
	
	public RestTemplateTokenInterceptor(OauthTokenData oAuthTokenHeaderData) { 
		super();
		this.oAuthToken = oAuthTokenHeaderData;
	} 
	
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
    	request.getHeaders().add("Authorization",  tokenBuilderService.prepareToken(oAuthToken));
        ClientHttpResponse response = execution.execute(request, body); 
        return response;
    }
}