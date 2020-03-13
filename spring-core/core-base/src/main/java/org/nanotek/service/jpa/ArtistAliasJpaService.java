package org.nanotek.service.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.ArtistAlias;
import org.nanotek.repository.jpa.ArtistAliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistAliasJpaService   extends BasePersistenceService<ArtistAlias,ArtistAliasRepository>{

	
	@Autowired
	ArtistAliasRepository repository;
	
	public ArtistAliasJpaService(@Autowired
			ArtistAliasRepository repository) {
		this.baseRepository = repository;
	}

	public Iterable<ArtistAlias> findByNameContainingIgnoreCase(String name) {
		return repository.findByNameContainingIgnoreCase(name);
	}

	public Optional<ArtistAlias> findByAliasId(@NotNull Long aliasId) {
		return repository.findByAliasId(aliasId);
	}

}
