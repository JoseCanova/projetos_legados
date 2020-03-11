package org.nanotek.service.jpa;

import java.util.Optional;

import org.nanotek.beans.entity.ArtistType;
import org.nanotek.repository.jpa.ArtistTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistTypeService extends BasePersistenceService<ArtistType,Long> {

	private static final long serialVersionUID = 3238318006531548699L;
	
	@Autowired
	ArtistTypeRepository repository;

	@Override
	public Optional<ArtistType> findById(Long k) {
		return repository.findById(k);
	} 
	
	public Iterable<ArtistType> findByNameContaining(String name){ 
		return repository.findByNameContainingIgnoreCase(name);
	}

	public Optional<ArtistType> findByTypeId(Long id) {
		return repository.findByTypeId(id);
	}
	
}
