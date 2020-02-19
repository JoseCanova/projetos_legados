package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.repository.jpa.ArtistCreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
	public  Optional<ArtistCredit> findById(Long k) {
		return artistCreditRepository.findById(k);
	}
	
}
