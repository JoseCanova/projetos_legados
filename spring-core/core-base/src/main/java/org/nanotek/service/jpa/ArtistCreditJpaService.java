package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.repository.jpa.ArtistCreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistCreditJpaService extends BasePersistenceService<ArtistCredit,Long> {

	@Autowired
	private ArtistCreditRepository artistCreditRepository;

	@Transactional
	public ArtistCredit save(ArtistCredit ArtistCredit) { 
		return artistCreditRepository.save(ArtistCredit);
	}
	
	@Transactional
	public List<ArtistCredit> saveAll(List<ArtistCredit> list) { 
		return artistCreditRepository.saveAll(list);
	}

	@Override
	@Transactional
	@Cacheable(cacheNames="credits", key="#id")
	public  Optional<ArtistCredit> findById(Long id) {
		return artistCreditRepository.findById(id);
	}
	
	@Transactional
	@Cacheable(cacheNames="credits", key="#id")
	public  ArtistCredit findByIdCache(Long id) {
		Optional<ArtistCredit>  opt = artistCreditRepository.findById(id);
		return opt.isPresent() ? opt.get() : null;
	}
	
	
}
