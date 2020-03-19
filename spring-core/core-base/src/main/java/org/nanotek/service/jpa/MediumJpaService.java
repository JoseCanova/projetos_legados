package org.nanotek.service.jpa;

import org.nanotek.beans.entity.Medium;
import org.nanotek.repository.jpa.MediumRepository;
import org.nanotek.service.LongIdNameEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class MediumJpaService<K extends Medium<K>> extends LongIdNameEntityService<K,MediumRepository<K>> {

	public MediumJpaService(@Autowired MediumRepository<K> rep) {
		super(rep);
	}

	@Override
	public Iterable<K> findByNameContainingIgnoreCase(String name) {
		return baseRepository.findByNameContainingIgnoreCase(name);
	}

}
