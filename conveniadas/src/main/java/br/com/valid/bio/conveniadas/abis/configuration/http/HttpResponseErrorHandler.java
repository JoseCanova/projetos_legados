package br.com.valid.bio.conveniadas.abis.configuration.http;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;

@Component
public class HttpResponseErrorHandler extends DefaultResponseErrorHandler {

	public HttpResponseErrorHandler() {
	}

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return !(response.getStatusCode() == HttpStatus.OK 
				|| response.getStatusCode() == HttpStatus.NO_CONTENT 
				|| response.getStatusCode() == HttpStatus.BAD_REQUEST
				|| response.getStatusCode() == HttpStatus.NOT_FOUND
				|| response.getStatusCode() == HttpStatus.CREATED);
//				|| response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
