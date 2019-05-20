package org.nanotek.integration;

import org.apache.log4j.Logger;
import org.nanotek.repository.RecordingRepository;
import org.nanotek.ws.xml.Artist;
import org.nanotek.ws.xml.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RecordingService {

	private static Logger log = Logger.getLogger(RecordingService.class);
	
	@Autowired 
	RecordingRepository recordingRepository; 
	
	@ServiceActivator
	public Message<?> findRecordings(Message<Artist> payload)
	{ 
		Artist artist = payload.getPayload();
		log.debug("Poocessing Recordings" + artist.toString());
		artist.getCredits().forEach(
					p -> recordingRepository.findByArtistCredit(p.getId()).stream().
					 forEach(p1 ->artist.getRecords().add(new Record (p1.getRecordingId() , p1.getName() , p1.getArtistCredit())))
				);
		
		return MessageBuilder.withPayload(artist).copyHeaders(payload.getHeaders()).build();
	}
}
