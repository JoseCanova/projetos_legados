package br.com.valid.bio.utils;

import java.util.List;

import br.com.valid.bio.conveniadas.model.AgreementRequest;
import br.com.valid.bio.conveniadas.model.agreement.Service;

public class AgreementUtils {

	public static Service findAgreementService(AgreementRequest agreementRequest) {
		List<Service> services = agreementRequest.getAgreement().getServices();
		return services.stream().filter(s -> selectService(s , agreementRequest)).findFirst().get();
	}
	
	private static boolean selectService(Service service, AgreementRequest agreementRequest) {
		String method = agreementRequest.getMethod();
		String serviceName = agreementRequest.getServiceName();
		return serviceName.equals(service.getOperation()) 
					&& 
			   method.equals(service.getMethod());
	}
}
