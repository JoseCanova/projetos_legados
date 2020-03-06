package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.Medium;
import org.nanotek.repository.jpa.MediumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;

public class MediumJpaService extends BasePersistenceService<Medium,Long> {

	private static final long serialVersionUID = 4661067648228104876L;
	
	
	@Autowired
	private MediumRepository mediumRepository;
	

	@Transactional
	public Medium save(Medium Medium) { 
		return mediumRepository.save(Medium);
	}
	
	@Transactional
	public List<Medium> saveAll(List<Medium> list) { 
		return mediumRepository.saveAll(list);
	}

	@Override
	@Transactional
	public  Optional<Medium> findById(Long k) {
		return mediumRepository.findById(k);
	}
	
	@Transactional
	public  Optional<Medium> findOne(Example<Medium> example) {
		return mediumRepository.findOne(example);
	}
	
	@Transactional
	public Iterable<Medium> findByNameContaining(@NotNull @NotEmpty String name){ 
		return mediumRepository.findByNameContainingIgnoreCase(name);
	}

}
