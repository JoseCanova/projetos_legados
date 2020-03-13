package org.nanotek.service.jpa;

import org.nanotek.beans.entity.ArtistAliasType;
import org.nanotek.repository.jpa.ArtistAliasTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistAliasTypeJpaService extends BaseTypePersistenceService<ArtistAliasType, ArtistAliasTypeRepository> {
	
	public ArtistAliasTypeJpaService(@Autowired ArtistAliasTypeRepository rep) {
		super(rep);
	}

}
