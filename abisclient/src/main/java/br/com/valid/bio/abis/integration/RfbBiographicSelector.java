package br.com.valid.bio.abis.integration;

import static br.com.valid.bio.utils.DateUtils.*;

import org.springframework.integration.core.GenericSelector;
import org.springframework.stereotype.Component;

import br.com.valid.bio.abis.model.JsonMessage;

@Component
public class RfbBiographicSelector implements GenericSelector<JsonMessage> {

	public RfbBiographicSelector() {
	}

	@Override
	public boolean accept(JsonMessage m) {
		boolean hasDateOfBirth = m.getBirthDate() !=null && isDate(m.getBirthDate());
		boolean hasDocument = m.getDocument() !=null;
		return hasDateOfBirth && hasDocument;
	}

}
