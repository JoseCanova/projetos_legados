package br.com.valid.bio.conveniadas.abis.service.transformers;

import br.com.valid.bio.conveniadas.model.AgreementRequest;

public interface AgreementRequestTransformer<T> extends Transformer<T,AgreementRequest>{
	@Override
	T apply(AgreementRequest source);
}
