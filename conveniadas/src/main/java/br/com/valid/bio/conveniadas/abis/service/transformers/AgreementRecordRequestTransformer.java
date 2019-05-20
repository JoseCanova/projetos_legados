package br.com.valid.bio.conveniadas.abis.service.transformers;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import br.com.valid.bio.conveniadas.abis.model.request.BaseRequest;
import br.com.valid.bio.conveniadas.model.AgreementRequest;

@Mapper
public interface AgreementRecordRequestTransformer  extends AgreementRequestTransformer<BaseRequest>{

	@Mappings({
		
	})
	@Override
	BaseRequest apply(AgreementRequest source);
	
}
