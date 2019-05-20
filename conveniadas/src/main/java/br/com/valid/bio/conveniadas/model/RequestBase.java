package br.com.valid.bio.conveniadas.model;

import br.com.valid.bio.conveniadas.model.agreement.Agreement;

public abstract class RequestBase implements Base<String>{
	
	public  abstract Agreement getAgreement();
	
	public abstract String getDocument();
	
	public abstract Integer getTransactionId();
}
