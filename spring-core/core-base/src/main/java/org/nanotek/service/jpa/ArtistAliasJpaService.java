package org.nanotek.service.jpa;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.nanotek.ArtistAlias;
import org.nanotek.repository.jpa.ArtistAliasRepository;
import org.nanotek.service.LongIdNameEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistAliasJpaService   extends LongIdNameEntityService<ArtistAlias,ArtistAliasRepository>{

	
	@Autowired
	ArtistAliasRepository repository;
	
	public ArtistAliasJpaService(@Autowired
			ArtistAliasRepository rep) {
		super(rep);
	}

	@Transactional
	public Optional<ArtistAlias> findByAliasId(@NotNull Long aliasId) {
		return repository.findByAliasId(aliasId);
	}

}
