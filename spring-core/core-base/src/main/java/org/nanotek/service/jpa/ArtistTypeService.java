package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import org.nanotek.beans.entity.ArtistType;
import org.nanotek.repository.jpa.ArtistTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistTypeService extends BasePersistenceService<ArtistType, ArtistTypeRepository>  {

	private ArtistTypeRepository typeRepository;
	
	public ArtistTypeService(@Autowired ArtistTypeRepository baseRepository) { 
		this.baseRepository = baseRepository;
		this.typeRepository = baseRepository;
	}

	@Override
	@Transactional
	public Optional<ArtistType> findById(Long k) {
		return baseRepository.findById(k);
	} 
	
	@Transactional
	public Iterable<ArtistType> findByNameContainingIgnoreCase(String name){ 
		return typeRepository.findByNameContainingIgnoreCase(name);
	}

	@Transactional
	public Optional<ArtistType> findByTypeId(Long id) {
		return typeRepository.findByTypeId(id);
	}
	
	@Override
	@Transactional
	public List<ArtistType> findAll() {
		return baseRepository.findAll();
	}
	
}
