package br.com.valid.bio.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.valid.bio.conveniadas.abis.model.TransactionStateEnum;
import br.com.valid.bio.conveniadas.abis.model.enroll.EnrollResponse;

public class TesteSerializacaoResponse {

	public TesteSerializacaoResponse() {
	}

	public static void main(String[] args) throws JsonProcessingException {
		EnrollResponse er = new EnrollResponse();
		er.setTransactionState(TransactionStateEnum.RECEIVED);
		ObjectMapper om = new ObjectMapper();
		System.out.println(om.writeValueAsString(er));
	}

}
