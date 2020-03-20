package org.nanotek.service.jpa;

import org.nanotek.beans.entity.Area;
import org.nanotek.repository.jpa.AreaRepository;
import org.nanotek.service.LongIdGidNameEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaJpaService<K extends Area<K>> extends LongIdGidNameEntityService<K, AreaRepository<K>>  {
	
	public AreaJpaService (@Autowired AreaRepository<K> rep){ 
		super(rep);
	}

	@Override
	public Iterable<K> findByNameContainingIgnoreCase(String name) {
		return baseRepository.findByNameContainingIgnoreCase(name);
	}
	
}
