package br.com.valid.bio.conveniadas.abis.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import br.com.valid.bio.conveniadas.model.AgreementRequest;

@Component
@Qualifier(value="parameterPopulatorService")
public class ParameterPopulatorService {

	
	public ParameterPopulatorService() {
	}
	
	public Map<String, String> populatetKey(Message<AgreementRequest> requestMessage) throws ParseException {
		Map<String, String> variables = new HashMap<String, String>();
		KeyParameter keyParameter = getParameterKeyFromRequestMessage(requestMessage);
		variables.put(keyParameter.getName(), keyParameter.getValue());
		return variables;
	}
	
	private KeyParameter getParameterKeyFromRequestMessage(Message<AgreementRequest> requestMessage) {
		return  (KeyParameter) requestMessage.getHeaders().get("transactionId");
	}

}
