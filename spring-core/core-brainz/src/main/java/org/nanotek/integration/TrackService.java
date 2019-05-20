package org.nanotek.integration;

import java.util.List;

import org.apache.log4j.Logger;
import org.nanotek.repository.TrackRepository;
import org.nanotek.ws.xml.Artist;
import org.nanotek.ws.xml.Record;
import org.nanotek.ws.xml.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component(value="trackService")
public class TrackService {

	private static final Logger log = Logger.getLogger(TrackService.class);
	
	@Autowired
	TrackRepository trackRepository; 
	
	@ServiceActivator/*(inputChannel="artistOutputChannel" , outputChannel="releaseOutputChannel")*/
	public Message<?> findTracks(Message<Artist> payload){
		
		log.debug("Processing tracks ");
		Artist artist = payload.getPayload();
		/*List<Record> records = artist.getRecords(); */
		/*artist.getRecords().stream().allMatch(r -> trackRepository.findByRecordingId(r.getId()).stream().forEach(t -> new Track(track));*/
		artist.getRecords().parallelStream().forEach(r -> trackRepository.findByRecordingId(r.getId()).stream().forEach(t -> r.getTracks().add(new Track(t)))) ; 
		/*for (Record record : records) 
		{ 
			List<org.nanotek.beans.Track> tracks = trackRepository.findByRecordingId(record.getId());
			for (org.nanotek.beans.Track track : tracks )
			{ 
				Track t = new Track(track);
				record.getTracks().add(t);
			}
			
		}*/
		
	/*	artist.getRecords().forEach(p -> trackRepository.findByRecordingId(p.getId()).forEach(p1 -> p.getTracks().add(new Track(p1))));*/
		log.debug("Finshed tracks ");
		return MessageBuilder.withPayload(artist).copyHeaders(payload.getHeaders()).build();
	}
}
