package org.nanotek.service.http;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.nanotek.beans.ArtistName;
import org.nanotek.service.jpa.ArtistNameJpaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AsyncHttpClientServices {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	  
    final String uri = "http://localhost:8080/artist/next";

    @Autowired
    private ArtistNameJpaService artistNameJpaService;
    
	@Async("threadPoolTaskExecutor")
	public Future<String> process() throws InterruptedException {
	    RestTemplate restTemplate = new RestTemplate();
	    ArtistName artist; 
	    log.info("started");
	    boolean valid = false;
	    do {
	    	artist = restTemplate.getForObject(uri, ArtistName.class);
	    	if (artist !=null) { 
	    		valid = validateArtist(artist);
	    		if (valid) {
	    			artistNameJpaService.save(artist);
	    		}
	    	}
	    }while((artist != null));
		return new AsyncResult<>("finished : " + Thread.currentThread().getId());
	}

	private boolean validateArtist(ArtistName artist) {
		return artist.getArtistId() != null  && artist.getName() !=null && artist.getSortName() !=null;
	}
}
