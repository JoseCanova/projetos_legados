package org.nanotek.service.http;

import java.util.Optional;
import java.util.concurrent.Future;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArtistCreditAsyncHttpClientServices {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	final String uri = "http://localhost:8080/artist_credit/next";

	@Autowired
	private ArtistCreditJpaService jpaService;

	@Autowired
	@Qualifier("serviceTaskExecutor")
	private ThreadPoolTaskExecutor taskExecutor;

//	@Async("threadPoolTaskExecutor")
	public Future<String> process() throws InterruptedException {
		log.info("started");
		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				boolean valid = false;
				ArtistCredit testValue = null;
				RestTemplate restTemplate = new RestTemplate();
				do {
					ArtistCredit artistCredit = restTemplate.getForObject(uri, ArtistCredit.class);
					testValue = artistCredit;
					if (artistCredit !=null) { 
						valid = validateArtistCredit(artistCredit);
						if (valid) {
							jpaService.save(artistCredit);
						}
						log.info(artistCredit.toString());
					}
			}while((testValue != null));
			}});
			return new AsyncResult<>("started : " + Thread.currentThread().getId());
		}

		private boolean validateArtistCredit(ArtistCredit artist) {
			return Optional.ofNullable(artist.getArtistCreditId()).orElse(0L) != 0 &&  notEmpty(artist.getName());
		}

		private boolean notEmpty(String value) {
			return value !=null && !"".equals(value.trim());
		}

	}
