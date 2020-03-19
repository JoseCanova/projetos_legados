package org.nanotek.service.jpa;

import org.nanotek.beans.entity.Area;
import org.nanotek.repository.jpa.AreaRepository;
import org.nanotek.service.LongIdGidNameEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaJpaService extends LongIdGidNameEntityService<Area<?> , AreaRepository>  {
	
	public AreaJpaService (@Autowired AreaRepository rep){ 
		super(rep);
	}

	@Override
	public Iterable<Area<?>> findByNameContainingIgnoreCase(String name) {
		return baseRepository.findByNameContainingIgnoreCase(name);
	}
	
}
