package br.com.valid.bio.tests;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.valid.bio.conveniadas.model.AgreementRequest;
import br.com.valid.bio.conveniadas.model.agreement.Agreement;

public class AgreementRequestJsonSerializer {

	public AgreementRequestJsonSerializer() {
	}

	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		AgreementRequest ar = new AgreementRequest();
		ar.setDocument("CPF");
		ar.setEndPoint("the_endpoint");
		ar.setEventId("2345678");
		ar.setSubjectTags(Stream.of(new String[] {"a_gallery"}).collect(Collectors.toList()));
		ar.setId("the_id");
		ar.setMethod("PUT");
		ar.setDocument("16468987881");
		ar.setImageBase("");
		ar.setImageMd5("");
		ar.setAgreement(new Agreement());
		mapper.setDefaultPrettyPrinter(new DefaultPrettyPrinter());
		String value = mapper.writeValueAsString(ar);
		System.out.println(value);
	}

}
