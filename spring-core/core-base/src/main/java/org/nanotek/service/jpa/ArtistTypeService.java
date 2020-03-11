package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import org.nanotek.beans.entity.ArtistType;
import org.nanotek.repository.jpa.ArtistTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistTypeService extends BasePersistenceService<ArtistType,Long> {

	private static final long serialVersionUID = 3238318006531548699L;
	
	@Autowired
	ArtistTypeRepository repository;

	@Override
	@Transactional
	public Optional<ArtistType> findById(Long k) {
		return repository.findById(k);
	} 
	
	@Transactional
	public Iterable<ArtistType> findByNameContaining(String name){ 
		return repository.findByNameContainingIgnoreCase(name);
	}

	@Transactional
	public Optional<ArtistType> findByTypeId(Long id) {
		return repository.findByTypeId(id);
	}
	
	@Override
	@Transactional
	public List<ArtistType> findAll() {
		return repository.findAll();
	}
	
}
