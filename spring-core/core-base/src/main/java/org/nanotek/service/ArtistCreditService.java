package org.nanotek.service;

import javax.validation.Valid;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ArtistCreditService {

	@Autowired
	ArtistCreditJpaService jpaService;
	
	public ArtistCreditService() {
	}

	public void save(@Valid ArtistCredit artistCredit) { 
		jpaService.save(artistCredit);
	}
}
