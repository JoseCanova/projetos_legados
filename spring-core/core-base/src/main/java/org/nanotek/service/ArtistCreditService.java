package org.nanotek.service;

import java.util.Optional;

import org.nanotek.beans.entity.ArtistCredit;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ArtistCreditService implements BaseService<ArtistCredit,Long>{

	private static final long serialVersionUID = 5324723400955565335L;
	
	@Autowired
	ArtistCreditJpaService jpaService;
	
	public ArtistCreditService() {
	}

	public void save(ArtistCredit artistCredit) { 
		jpaService.save(artistCredit);
	}
	
	public Optional<ArtistCredit> findById(Long id) { 
		return jpaService.findById(id);
	}
}
