package org.nanotek.service.jpa;

import java.util.Optional;

import org.nanotek.beans.entity.Area;
import org.nanotek.repository.jpa.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AreaJpaService extends BasePersistenceService<Area, Long> {
	
	@Autowired
	AreaRepository rep;
	
	private static final long serialVersionUID = -7181277878701701552L;

	@Override
	@Transactional
	public Optional<Area> findById(Long k) {
		return rep.findById(k);
	}
	
	@Transactional
	public Area save (Area area) { 
		return rep.save(area);
	}

	@Transactional
	public Iterable<Area> findByNameContaining(String name) {
		return rep.findByNameContainingIgnoreCase(name);
	}

}
