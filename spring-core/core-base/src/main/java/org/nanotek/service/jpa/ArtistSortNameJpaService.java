package org.nanotek.service.jpa;

import java.util.Optional;

import org.nanotek.beans.entity.ArtistSortName;
import org.nanotek.repository.jpa.ArtistSortNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistSortNameJpaService extends BasePersistenceService<ArtistSortName, Long> {

	private static final long serialVersionUID = 6744665690728195270L;

	@Autowired
	ArtistSortNameRepository repository;
	
	public ArtistSortNameJpaService() {
	}

	public Optional<ArtistSortName> findById(Long k) {
		return repository.findById(k);
	}

	public Iterable<ArtistSortName> findByNameContaining(String name){
		return repository.findBySortNameContainingIgnoreCase(name);
	}
	
}
