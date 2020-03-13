package org.nanotek.service.jpa;

import org.nanotek.beans.entity.AreaType;
import org.nanotek.repository.jpa.AreaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

//TODO: Create support for ExampleMathcers
@Service
@Validated
public class AreaTypeJpaService extends BaseTypePersistenceService<AreaType , AreaTypeRepository> {
	
	public AreaTypeJpaService(@Autowired AreaTypeRepository rep) {
		super(rep);
	}

}
