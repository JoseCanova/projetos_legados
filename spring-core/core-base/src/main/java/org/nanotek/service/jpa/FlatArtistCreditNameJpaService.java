package org.nanotek.service.jpa;

import org.nanotek.beans.flat.FlatArtistCreditName;
import org.nanotek.repository.jpa.FlatArtistCreditNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlatArtistCreditNameJpaService {

	@Autowired
	FlatArtistCreditNameRepository repository;
	
	public FlatArtistCreditName save (FlatArtistCreditName acn) { 
		return saveInTransaction(acn);
	}
	
	@Transactional
	public FlatArtistCreditName saveInTransaction (FlatArtistCreditName acn) { 
		return repository.save(acn);
	}
	
}
