package org.nanotek.service.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.ArtistCredit;
import org.nanotek.repository.jpa.ArtistCreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//<O extends ArtistCredit , R extends LongIdNameEntityRepository> 
@Service
public class ArtistCreditJpaService extends LongIdNameEntityService<ArtistCredit, ArtistCreditRepository>  {


	public ArtistCreditJpaService(@Autowired ArtistCreditRepository rep) {
		super(rep);
	}

	@Transactional
	public Optional<ArtistCredit> findByArtistCreditId(@NotNull Long artistCreditId){ 
		return baseRepository.findByArtistCreditId(artistCreditId);
	}
	
	@Transactional
//	@Cacheable(cacheNames="credits", key="#id")
	public  ArtistCredit findArtistCreditRecordingsById(Long id) {
		Optional<ArtistCredit>  opt = baseRepository.findArtistCreditRecordingsById(id);
		return opt.isPresent() ? opt.get() : null;
	}

}
