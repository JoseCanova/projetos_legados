package org.nanotek.controller.async;

import org.nanotek.service.http.ArtistCreditAsyncHttpClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ArtistCreditServiceAsyncController {

	@Autowired
	ArtistCreditAsyncHttpClientServices asyncHttpClientServices;

	@Autowired
	@Qualifier("serviceTaskExecutor")
	private ThreadPoolTaskExecutor taskExecutor;

	@RequestMapping("/artist_credit/run")
	public String run() 	{
		StringBuffer log = new StringBuffer();
		asyncHttpClientServices.process();
		log.append("Started Request");
		return log.toString();
	}
}
