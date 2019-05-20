package br.com.valid.bio.conveniadas.abis.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import br.com.valid.bio.conveniadas.model.AgreementRequest;

@Component
@Qualifier(value="methodResolverService")
public class MethodResolverService {

	@Autowired
	@Qualifier("methodToHttpMethodInterpreter")
	private Map<String , HttpMethod> methodInterpreter;
	
	
	public HttpMethod resolveMethod(final String methodStr) { 
		return methodInterpreter.get(methodStr);
	}
	
	public HttpMethod resolveMethod(final AgreementRequest agreementRequest) { 
		String methodStr = agreementRequest.getMethod();
		return methodInterpreter.get(methodStr);
	}
	
}
