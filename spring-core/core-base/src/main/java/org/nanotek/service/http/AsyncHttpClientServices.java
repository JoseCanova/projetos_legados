package org.nanotek.service.http;

import java.util.concurrent.Future;

import org.nanotek.beans.ArtistName;
import org.nanotek.service.mq.ArtistNameDispatcherService;
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
	ArtistNameDispatcherService dispatcher;

	@Async("threadPoolTaskExecutor")
	public Future<String> process() throws InterruptedException {
		RestTemplate restTemplate = new RestTemplate();
		ArtistName artist;
		log.info("started");
		boolean valid = false;
		do {
			artist = restTemplate.getForObject(uri, ArtistName.class);
			if (artist !=null) {
				dispatcher.dispatch(artist);
				log.info(artist.toString());
			}
		}while((artist != null));
		return new AsyncResult<>("finished : " + Thread.currentThread().getId());
	}

}
