package org.nanotek.service.jpa;

import java.util.Optional;

import org.nanotek.beans.entity.ArtistAliasType;
import org.nanotek.repository.jpa.ArtistAliasTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistAliasTypeJpaService<K extends ArtistAliasType<K,?>> extends BaseTypePersistenceService<K, ArtistAliasTypeRepository<K>> {
	
	public ArtistAliasTypeJpaService(@Autowired ArtistAliasTypeRepository<K> rep) {
		super(rep);
	}

	@Override
	public Optional<K> findByTypeId(Long typeId) {
		return baseRepository.findByTypeId(typeId);
	}

	@Override
	public Iterable<K> findByNameContainingIgnoreCase(String name) {
		return baseRepository.findByNameContainingIgnoreCase(name);
	}

}
