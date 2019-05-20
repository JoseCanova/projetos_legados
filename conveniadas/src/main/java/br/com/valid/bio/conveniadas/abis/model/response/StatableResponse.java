package br.com.valid.bio.conveniadas.abis.model.response;

import br.com.valid.bio.conveniadas.abis.model.TransactionStateEnum;
import br.com.valid.bio.conveniadas.model.Response;

public interface StatableResponse extends Response  {

	default String getId() { 
		return "";
	}
	
	default TransactionStateEnum getTransactionState() { 
		return TransactionStateEnum.DONE;
	}
	
}
