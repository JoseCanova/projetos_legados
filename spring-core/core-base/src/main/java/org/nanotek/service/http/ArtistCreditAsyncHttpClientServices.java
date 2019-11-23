package org.nanotek.service.http;

import java.util.Optional;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	public void process() {
		log.info("started");
		RestTemplate restTemplate = new RestTemplate();
		ArtistCredit testValue;
		do {
			ArtistCredit artistCredit;
			artistCredit = restTemplate.getForObject(uri, ArtistCredit.class);
			testValue = artistCredit;
			taskExecutor.execute(new Runnable() {
				public void run() {
					if (artistCredit !=null) { 
						if (validateArtistCredit(artistCredit)) {
							jpaService.save(artistCredit);
						}
					}
				}
				private boolean validateArtistCredit(ArtistCredit artist) {
					return Optional.ofNullable(artist.getArtistCreditId()).orElse(0L) != 0 &&  notEmpty(artist.getName());
				}
			});
		}while((testValue != null));

	}

	private static boolean notEmpty(String value) {
		return value !=null && !"".equals(value.trim());
	}

}
