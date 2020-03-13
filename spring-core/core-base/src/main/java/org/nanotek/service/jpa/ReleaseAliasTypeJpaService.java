package org.nanotek.service.jpa;

import java.util.Optional;

import org.nanotek.beans.entity.ReleaseAliasType;
import org.nanotek.repository.jpa.ReleaseAliasTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReleaseAliasTypeJpaService extends BaseTypePersistenceService<ReleaseAliasType,ReleaseAliasTypeRepository> {

	public ReleaseAliasTypeJpaService(@Autowired ReleaseAliasTypeRepository rep) {
		super(rep);
	}
	
	@Transactional
	public Optional<ReleaseAliasType> findByTypeId(Long typeId) { 
		return baseRepository.findByTypeId(typeId);
	}
}