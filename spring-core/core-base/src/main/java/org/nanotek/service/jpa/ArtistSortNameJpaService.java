package org.nanotek.service.jpa;

import java.util.Optional;

import org.nanotek.beans.entity.ArtistSortName;
import org.nanotek.repository.jpa.ArtistSortNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistSortNameJpaService<K extends ArtistSortName<K>> extends BasePersistenceService<K , ArtistSortNameRepository<K>> {

	
	public ArtistSortNameJpaService(@Autowired ArtistSortNameRepository<K> artistSortNameRepository) {
		super(artistSortNameRepository);
	}

	public Optional<K> findById(Long k) {
		return baseRepository.findById(k);
	}

	public Iterable<K> findByNameContaining(String name){
		return baseRepository.findBySortNameContainingIgnoreCase(name);
	}

}
