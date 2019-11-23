package org.nanotek.service.http;

import java.util.Optional;

import org.nanotek.beans.ArtistCreditName;
import org.nanotek.beans.csv.ArtistCreditNameBean;
import org.nanotek.service.jpa.ArtistCreditNameJpaService;
import org.nanotek.service.tranformer.ArtistCreditNameTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArtistCreditNameAsyncHttpClientServices {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	final String uri = "http://localhost:8080/artist_credit_name_bean/next";

	@Autowired
	private ArtistCreditNameJpaService jpaService;

	@Autowired
	private ArtistCreditNameTransformer transformer;
	
	@Autowired
	@Qualifier("serviceTaskExecutor")
	private ThreadPoolTaskExecutor taskExecutor;

	//	@Async("threadPoolTaskExecutor")
	public void process() {
		log.info("started");
		RestTemplate restTemplate = new RestTemplate();
		ArtistCreditNameBean testValue;
		do {
			ArtistCreditNameBean artistCreditName;
			artistCreditName = restTemplate.getForObject(uri, ArtistCreditNameBean.class);
			testValue = artistCreditName;
			taskExecutor.execute(new Runnable() {
				public void run() {
					if (artistCreditName !=null) { 
						if (validateArtistCreditName(artistCreditName)) {
							ArtistCreditName acn = transformer.transform(artistCreditName);
							if(acn != null)
								jpaService.save(acn);
								log.info("ArtistCreditName " + Optional.ofNullable(acn).orElse(ArtistCreditName.NULL_VALUE()));
						}
					}
				}
				private boolean validateArtistCreditName(ArtistCreditNameBean artist) {
					return Optional.ofNullable(artist.getArtistCreditId()).orElse(0L) != 0 
								&&  notEmpty(artist.getName()) 
								&& Optional.ofNullable(artist.getArtistId()).orElse(0L) !=0;
				}
			});
		}while((testValue != null));

	}

	private static boolean notEmpty(String value) {
		return value !=null && !"".equals(value.trim());
	}

}
