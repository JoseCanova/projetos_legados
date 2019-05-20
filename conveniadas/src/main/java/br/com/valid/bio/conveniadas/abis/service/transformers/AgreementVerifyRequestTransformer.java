package br.com.valid.bio.conveniadas.abis.service.transformers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.valid.bio.conveniadas.abis.model.request.BaseRequest;
import br.com.valid.bio.conveniadas.model.AgreementRequest;

@Mapper
public interface AgreementVerifyRequestTransformer  extends AgreementRequestTransformer<BaseRequest>{

	@Mappings({
		@Mapping(source = "imageBase", target = "referenceImageData"),
		@Mapping(target = "referenceImageType", expression="java(br.com.valid.bio.conveniadas.abis.model.ImageTypeEnum.DATA)"),
		@Mapping(source = "faceId", target = "probeImageKey"),
		@Mapping(source = "waitTimeout" , target="waitTimeout" , defaultValue = "0")
	})
	@Override
	BaseRequest apply(AgreementRequest source);
	
}
