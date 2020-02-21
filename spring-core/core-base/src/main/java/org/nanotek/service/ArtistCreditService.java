package org.nanotek.service;

import javax.validation.Valid;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ArtistCreditService {

	@Autowired
	ArtistCreditJpaService jpaService;
	
	public ArtistCreditService() {
	}

	public void save(@Valid ArtistCredit artistCredit) { 
		jpaService.save(artistCredit);
	}
}
