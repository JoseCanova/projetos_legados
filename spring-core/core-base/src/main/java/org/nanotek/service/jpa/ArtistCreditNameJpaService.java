package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import org.nanotek.beans.entity.ArtistCreditName;
import org.nanotek.repository.jpa.ArtistCreditNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistCreditNameJpaService<K extends ArtistCreditName<K>> extends BasePersistenceService<K,ArtistCreditNameRepository<K>> {

	public ArtistCreditNameJpaService(@Autowired  ArtistCreditNameRepository<K> baseRepository) {
		super(baseRepository);
	}

	@Transactional
	public List<K> findByArtistCreditId(Long id){ 
		return baseRepository.findByArtistCreditId(id);
	}
	
	@Transactional
	public Optional<K> findByArtistCreditNameId(Long id){
		return baseRepository.findByArtistCreditNameId(id);
	}

}
