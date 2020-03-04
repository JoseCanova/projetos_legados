package org.nanotek.service.jpa;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.InstrumentType;
import org.nanotek.repository.jpa.InstrumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class InstrumentTypeJpaService extends BasePersistenceService<InstrumentType, Long> {

	private static final long serialVersionUID = -1097949690707573749L;
	
	@Autowired
	InstrumentTypeRepository repository;
	
	@Override
	@Transactional
	public Optional<InstrumentType> findById(Long k) {
		return repository.findById(k);
	}
	
	@Transactional
	public InstrumentType save(InstrumentType bean) { 
		return repository.save(bean);
	}
	
	@Transactional
	public  Optional<InstrumentType> findOne(Example<InstrumentType> example) {
		return repository.findOne(example);
	}
	
	@Transactional
	public Iterable<InstrumentType> findByNameContaining(@NotNull @NotEmpty String name){ 
		return repository.findByNameContainingIgnoreCase(name);
	}
}
