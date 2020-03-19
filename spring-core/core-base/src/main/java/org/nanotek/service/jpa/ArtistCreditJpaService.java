package org.nanotek.service.jpa;

import java.util.Optional;

import org.nanotek.beans.entity.ArtistCredit;
import org.nanotek.repository.jpa.ArtistCreditRepository;
import org.nanotek.service.LongIdNameEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//<O extends ArtistCredit , R extends LongIdNameEntityRepository> 
@Service
public class ArtistCreditJpaService<K extends ArtistCredit<K>> extends LongIdNameEntityService<K, ArtistCreditRepository<K>>  {


	public ArtistCreditJpaService(@Autowired ArtistCreditRepository<K> rep) {
		super(rep);
	}

	@Transactional
	public Optional<K> findByArtistCreditId(Long artistCreditId){ 
		return baseRepository.findByArtistCreditId(artistCreditId);
	}
	
	@Transactional
//	@Cacheable(cacheNames="credits", key="#id")
	public  K findArtistCreditRecordingsById(Long id) {
		Optional<K>  opt = baseRepository.findArtistCreditRecordingsById(id);
		return opt.isPresent() ? opt.get() : null;
	}

	@Override
	public Iterable<K> findByNameContainingIgnoreCase(String name) {
		return baseRepository.findByNameContainingIgnoreCase(name);
	}

}
