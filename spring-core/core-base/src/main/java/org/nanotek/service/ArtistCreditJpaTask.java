package org.nanotek.service;

import java.util.concurrent.Callable;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistCreditJpaTask implements Callable<ArtistCredit>{

	@Autowired ArtistCreditJpaService jpaService; 
	
	public ArtistCreditJpaTask( ) {
	}
	
	@Override
	public ArtistCredit call() throws Exception {
		return null;
	}

}
