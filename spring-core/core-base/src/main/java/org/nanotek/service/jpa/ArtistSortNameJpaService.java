package org.nanotek.service.jpa;

import java.util.Optional;

import org.nanotek.beans.entity.ArtistSortName;
import org.nanotek.repository.jpa.ArtistSortNameRepository;
import org.nanotek.service.EntityBasePersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistSortNameJpaService extends EntityBasePersistenceService<ArtistSortName , ArtistSortNameRepository,Long> {

	protected ArtistSortNameRepository artistSortNameRepository;
	
	public ArtistSortNameJpaService(@Autowired ArtistSortNameRepository artistSortNameRepository) {
		this.artistSortNameRepository = artistSortNameRepository;
	}

	public Optional<ArtistSortName> findById(Long k) {
		return artistSortNameRepository.findById(k);
	}

	public Iterable<ArtistSortName> findByNameContaining(String name){
		return artistSortNameRepository.findBySortNameContainingIgnoreCase(name);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		baseRepository = artistSortNameRepository;
	}
	
}
