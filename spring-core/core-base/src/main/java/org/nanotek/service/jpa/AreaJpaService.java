package org.nanotek.service.jpa;

import org.nanotek.beans.entity.Area;
import org.nanotek.repository.jpa.AreaRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaJpaService<K extends Area<K>> extends BasePersistenceService<K>  implements InitializingBean{
	
	@Autowired AreaRepository<K> rep;
	
	public AreaJpaService (){ 
		super();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		baseRepository = rep;
	}
	
	public Iterable<K> findByNameContainingIgnoreCase(String name) {
		return rep.findByNameContainingIgnoreCase(name);
	}
	
}
