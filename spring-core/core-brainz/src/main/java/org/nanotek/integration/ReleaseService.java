package org.nanotek.integration;

import org.nanotek.beans.Release;
import org.nanotek.repository.ReleaseRepository;
import org.nanotek.ws.xml.Artist;
import org.nanotek.ws.xml.ArtistRelease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ReleaseService {

	@Autowired
	ReleaseRepository releaseRepository;
	
	@Transactional
	public Message<?> findReleases(Message<Artist> message){
		Artist artist = message.getPayload();
		artist.getCredits().stream().mapToLong(p -> p.getId()).forEach(p1 ->
				releaseRepository.findByArtistCredit(p1).stream().forEach(r -> artist.getReleases().add(transform(r))));
		return MessageBuilder.withPayload(artist).copyHeaders(message.getHeaders()) .build();
	}
	
	ArtistRelease transform(Release  s)
	{ 
		return new ArtistRelease(s);
	}

}
