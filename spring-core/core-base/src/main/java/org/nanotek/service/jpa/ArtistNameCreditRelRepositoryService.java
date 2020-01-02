package org.nanotek.service.jpa;

import org.nanotek.beans.flat.FlatArtistNameCreditRel;
import org.nanotek.repository.jpa.ArtistNameCreditRelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistNameCreditRelRepositoryService {

	@Autowired
	ArtistNameCreditRelRepository repository;
	
	public FlatArtistNameCreditRel save(FlatArtistNameCreditRel entity) { 
		return repository.save(entity);
	};
	
}
