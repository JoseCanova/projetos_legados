package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import org.nanotek.beans.entity.ArtistType;
import org.nanotek.repository.jpa.ArtistTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistTypeService<K extends ArtistType<K>> extends BasePersistenceService<K, ArtistTypeRepository<K>>  {

	
	public ArtistTypeService(@Autowired ArtistTypeRepository<K> baseRepository) { 
		super(baseRepository);
	}

	@Override
	@Transactional
	public Optional<K> findById(Long k) {
		return baseRepository.findById(k);
	} 
	
	@Transactional
	public Iterable<K> findByNameContainingIgnoreCase(String name){ 
		return baseRepository.findByNameContainingIgnoreCase(name);
	}

	@Transactional
	public Optional<K> findByTypeId(Long id) {
		return baseRepository.findByTypeId(id);
	}
	
	@Override
	@Transactional
	public List<K> findAll() {
		return baseRepository.findAll();
	}
	
}
