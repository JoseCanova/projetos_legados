package br.com.valid.bio.conveniadas.abis.service.transformers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.valid.bio.conveniadas.abis.model.enroll.EnrollRequest;
import br.com.valid.bio.conveniadas.model.AgreementRequest;

@Mapper
public interface AgreementEnrollRequestTransformer extends AgreementRequestTransformer<EnrollRequest>{
	
	@Mappings({
        @Mapping(source = "imageBase", target = "imageData"),
        @Mapping(source = "document", target = "subjectKey"),
        @Mapping(target = "imageType", expression="java(br.com.valid.bio.conveniadas.abis.model.ImageTypeEnum.DATA)"),
        @Mapping(target = "subjectBehavior", expression="java(br.com.valid.bio.conveniadas.abis.model.SubjectBehaviorEnum.CREATE)"),
        @Mapping(target = "imageBehaviour" , expression="java(br.com.valid.bio.conveniadas.abis.model.ImageBehaviorEnum.APPEND_KEEP)"),
        @Mapping(source = "waitTimeout" , target="waitTimeout" , defaultValue = "0"),
        @Mapping(source = "imageKey" , target="imageKey")
    })
	@Override
	EnrollRequest apply(AgreementRequest source);

}
