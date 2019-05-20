package br.com.valid.bio.conveniadas.abis.service.transformers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.valid.bio.conveniadas.abis.model.request.BaseRequest;
import br.com.valid.bio.conveniadas.model.AgreementRequest;

@Mapper
public interface AgreementMatchRequestTransformer extends AgreementRequestTransformer<BaseRequest>{

	@Mappings({
        @Mapping(source = "imageBase", target = "referenceImageData"),
        @Mapping(target = "referenceImageType", expression="java(br.com.valid.bio.conveniadas.abis.model.ImageTypeEnum.DATA)"),
//        @Mapping(source = "referenceImageToken" , target="referenceImageToken"),
//        @Mapping(source = "listSize" , target = "listSize", defaultValue = "0"),
//        @Mapping(source = "waitTimeout" , target="waitTimeout" , defaultValue = "0"),
//        @Mapping(source = "threshold" , target="threshold" , defaultValue = "0"),
//        @Mapping(source = "probeImageType" , target = "probeImageType"),
//        @Mapping(source = "probeImageData" , target = "probeImageData"),
//        @Mapping(source = "probeImageToken" , target = "probeImageToken")
	})
	@Override
	BaseRequest apply(AgreementRequest source);
}
