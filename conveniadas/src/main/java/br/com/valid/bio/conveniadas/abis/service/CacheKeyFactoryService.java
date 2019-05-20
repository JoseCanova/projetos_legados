package br.com.valid.bio.conveniadas.abis.service;


import static br.com.valid.bio.utils.AgreementUtils.findAgreementService;
import org.springframework.stereotype.Component;
import br.com.valid.bio.conveniadas.model.AgreementRequest;
import br.com.valid.bio.conveniadas.model.agreement.Service;


@Component
public class CacheKeyFactoryService {

	public CacheKeyFactoryService() {
	}

	public String generateKey(final AgreementRequest agreementRequest) {
		Service agreementService = findAgreementService(agreementRequest);
		return generateKeyFromAgreement(agreementService);
	}

	private String generateKeyFromAgreement(Service agreementService) {
		return new StringBuilder()
					.append(agreementService.getMethod())
					.append("_")
					.append(agreementService.getOperation()).toString();
	}

}
