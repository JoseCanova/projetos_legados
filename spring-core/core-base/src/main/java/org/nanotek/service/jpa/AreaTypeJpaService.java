package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.AreaType;
import org.nanotek.repository.jpa.AreaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

//TODO: Create support for ExampleMathcers
@Service
@Validated
public class AreaTypeJpaService extends BasePersistenceService<AreaType,Long> {

	private static final long serialVersionUID = -8374804487481237101L;
	
	@Autowired
	private AreaTypeRepository areaTypeRepository;
	

	@Transactional
	public AreaType save(AreaType AreaType) { 
		return areaTypeRepository.save(AreaType);
	}
	
	@Transactional
	public Optional<AreaType> findByTypeId(@NotNull Long typeId){ 
		return areaTypeRepository.findByTypeId(typeId);
	}
	
	@Transactional
	public List<AreaType> saveAll(List<AreaType> list) { 
		return areaTypeRepository.saveAll(list);
	}

	@Override
	@Transactional
	public  Optional<AreaType> findById(Long k) {
		return areaTypeRepository.findById(k);
	}
	
	@Transactional
	public  Optional<AreaType> findOne(Example<AreaType> example) {
		return areaTypeRepository.findOne(example);
	}
	
	@Transactional
	public Iterable<AreaType> findByNameContaining(@NotNull @NotEmpty String name){ 
		return areaTypeRepository.findByNameContainingIgnoreCase(name);
	}
	
	@Transactional
	public List<AreaType> findAll(){
		return areaTypeRepository.findAll();
	}
}
