package org.nanotek.service.http;

import java.util.concurrent.Future;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.ArtistName;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.nanotek.service.jpa.ArtistNameJpaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArtistCreditAsyncHttpClientServices {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	  
    final String uri = "http://localhost:8080/artist_credit/next";

    @Autowired
    private ArtistCreditJpaService jpaService;
    
	@Async("threadPoolTaskExecutor")
	public Future<String> process() throws InterruptedException {
	    RestTemplate restTemplate = new RestTemplate();
	    ArtistCredit artist; 
	    log.info("started");
	    boolean valid = false;
	    do {
	    	artist = restTemplate.getForObject(uri, ArtistCredit.class);
	    	if (artist !=null) { 
	    		valid = validateArtistCredit(artist);
	    		if (valid) {
	    			jpaService.save(artist);
	    			log.info(artist.toString());
	    		}
	    	}
	    }while((artist != null));
		return new AsyncResult<>("finished : " + Thread.currentThread().getId());
	}

	private boolean validateArtistCredit(ArtistCredit artist) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validateArtist(ArtistName artist) {
		return artist.getArtistId() != null  && artist.getName() !=null && artist.getSortName() !=null;
	}
}
