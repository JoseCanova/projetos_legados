package br.com.valid.bio.conveniadas.abis.service.transformers;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.valid.bio.conveniadas.model.AgreementRequest;

@Mapper
public interface AgreementSubjectRequestTransformer extends AgreementRequestTransformer<List<String>>{

	@Override
	default List<String> apply(AgreementRequest source) { 
		return source.getSubjectTags();
	}
	
}
