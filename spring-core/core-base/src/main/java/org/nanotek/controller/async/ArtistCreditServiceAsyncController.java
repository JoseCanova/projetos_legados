package org.nanotek.controller.async;

import java.util.concurrent.ExecutionException;

import org.nanotek.service.http.ArtistCreditAsyncHttpClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ArtistCreditServiceAsyncController {

	@Autowired
	ArtistCreditAsyncHttpClientServices asyncHttpClientServices;
	
	@RequestMapping("/artist_credit/run")
	public String run() throws InterruptedException, ExecutionException	{
		StringBuffer log = new StringBuffer();
		asyncHttpClientServices.process();
	    log.append("Started Request");
		return log.toString();
	}
}
