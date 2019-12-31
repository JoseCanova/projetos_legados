package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import org.nanotek.beans.ArtistCreditName;
import org.nanotek.repository.jpa.ArtistCreditNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistCreditNameJpaService extends BasePersistenceService<ArtistCreditName , Long> {

	
	@Autowired
	private ArtistCreditNameRepository repository;
	
	@Transactional
	public ArtistCreditName save(ArtistCreditName a) { 
		   return repository.save(a);
	}
	
	@Transactional
	public Optional<ArtistCreditName> findById(Long id) { 
		return  repository.findById(id);
	}
	
	@Transactional
	public List<ArtistCreditName> findByArtistCreditId(Long id){ 
		return repository.findByArtistCreditId(id);
	}
	
}
