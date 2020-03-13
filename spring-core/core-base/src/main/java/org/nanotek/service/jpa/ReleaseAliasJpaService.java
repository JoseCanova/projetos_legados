package org.nanotek.service.jpa;

import java.util.Optional;

import org.nanotek.beans.entity.ReleaseAlias;
import org.nanotek.repository.jpa.ReleaseAliasJpaRepository;
import org.nanotek.service.LongIdNameEntityService;
import org.springframework.stereotype.Service;

@Service
public class ReleaseAliasJpaService extends LongIdNameEntityService<ReleaseAlias,ReleaseAliasJpaRepository> {

	public ReleaseAliasJpaService(ReleaseAliasJpaRepository rep) {
		super(rep);
	}
	
    public Optional<ReleaseAlias> findByReleaseAliasId(Long id){ 
    	return baseRepository.findByReleaseAliasId(id);
    }

}
