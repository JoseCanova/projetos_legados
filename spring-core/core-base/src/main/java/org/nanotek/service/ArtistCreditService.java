package org.nanotek.service;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ArtistCreditService {

	@Autowired
	ArtistCreditJpaService jpaService;
	
	public ArtistCreditService() {
	}

	public void save(ArtistCredit artistCredit) { 
		jpaService.save(artistCredit);
	}
}
