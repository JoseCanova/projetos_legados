package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.ReleaseAliasType;
import org.nanotek.repository.jpa.ReleaseAliasTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;

public class ReleaseAliasTypeJpaService extends BasePersistenceService<ReleaseAliasType,Long> {

	
	private static final long serialVersionUID = 5497788522209567908L;
	
	@Autowired
	private ReleaseAliasTypeRepository areaTypeRepository;
	

	@Transactional
	public ReleaseAliasType save(ReleaseAliasType ReleaseAliasType) { 
		return areaTypeRepository.save(ReleaseAliasType);
	}
	
	@Transactional
	public List<ReleaseAliasType> saveAll(List<ReleaseAliasType> list) { 
		return areaTypeRepository.saveAll(list);
	}

	@Override
	@Transactional
	public  Optional<ReleaseAliasType> findById(Long k) {
		return areaTypeRepository.findById(k);
	}
	
	@Transactional
	public  Optional<ReleaseAliasType> findOne(Example<ReleaseAliasType> example) {
		return areaTypeRepository.findOne(example);
	}
	

	
	@Transactional
	public Iterable<ReleaseAliasType> findByNameContaining(@NotNull @NotEmpty String name){ 
		return areaTypeRepository.findByNameContainingIgnoreCase(name);
//		return ReleaseAliasTypeRepository.findByNameContainingIgnoreCase(name.toUpperCase());
	}
}