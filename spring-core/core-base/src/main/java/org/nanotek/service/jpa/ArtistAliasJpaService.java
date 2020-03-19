package org.nanotek.service.jpa;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.ArtistAlias;
import org.nanotek.repository.jpa.ArtistAliasRepository;
import org.nanotek.service.LongIdNameEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistAliasJpaService<K extends ArtistAlias<K>>   extends LongIdNameEntityService<K,ArtistAliasRepository<K>>{
	
	public ArtistAliasJpaService(@Autowired
			ArtistAliasRepository<K> rep) {
		super(rep);
	}

	@Transactional
	public Optional<K> findByAliasId(@NotNull Long aliasId) {
		return baseRepository.findByAliasId(aliasId);
	}

	@Override
	public Iterable<K> findByNameContainingIgnoreCase( String name) {
		return baseRepository.findByNameContainingIgnoreCase(name);
	}

}
