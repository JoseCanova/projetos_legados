package org.nanotek.service.jpa;

import java.util.List;

import org.nanotek.beans.entity.ArtistCreditName;
import org.nanotek.repository.jpa.ArtistCreditNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistCreditNameJpaService extends BasePersistenceService<ArtistCreditName,ArtistCreditNameRepository> {

	@Autowired
	private ArtistCreditNameRepository repository;
	
	
	@Transactional
	public ArtistCreditName save(ArtistCreditName a) { 
		   return repository.save(a);
	}
	
	@Transactional
	public List<ArtistCreditName> findByArtistCreditId(Long id){ 
		return repository.findByArtistCreditId(id);
	}

}
