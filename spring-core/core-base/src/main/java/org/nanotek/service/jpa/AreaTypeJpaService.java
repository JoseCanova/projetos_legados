package org.nanotek.service.jpa;

import java.util.Optional;

import org.nanotek.beans.entity.AreaType;
import org.nanotek.repository.jpa.AreaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

//TODO: Create support for ExampleMathcers
@Service
@Validated
public class AreaTypeJpaService extends BaseTypePersistenceService<AreaType<?> , AreaTypeRepository> {
	
	public AreaTypeJpaService(@Autowired AreaTypeRepository rep) {
		super(rep);
	}

	@Override
	public Iterable<AreaType<?>> findByNameContainingIgnoreCase( String name) {
		return baseRepository.findByNameContainingIgnoreCase(name);
	}

	@Override
	public Optional<AreaType<?>> findByTypeId(Long typeId) {
		return baseRepository.findByTypeId(typeId);
	}

}
