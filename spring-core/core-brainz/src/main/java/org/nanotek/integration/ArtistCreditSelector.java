package org.nanotek.integration;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.ArtistCreditName;
import org.nanotek.repository.ArtistCreditNameRepository;
import org.nanotek.repository.ArtistCreditRepository;
import org.nanotek.ws.xml.Artist;
import org.nanotek.ws.xml.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value="artistCreditSelector")
public class ArtistCreditSelector implements MessageSelector{

	@Autowired
	ArtistCreditRepository artistCreditRepository;
	
	@Autowired
	ArtistCreditNameRepository artistCreditNameRepository; 
	
	@Override
	@Transactional
	@Filter
	public boolean accept(Message<?> message) {
		Artist artist = ((Artist) message.getPayload());
		artistCreditNameRepository.findByArtist(artist.getId()).stream().forEach(new Consumer<ArtistCreditName>(){
			@Override
			public void accept(ArtistCreditName t) {
				ArtistCredit c = artistCreditRepository.findByArtistCreditId(t.getArtistCredit());
				System.out.println(artist.getCredits().hashCode());
				if (c !=null) artist.getCredits().add(transform(c , Credit::new));
				System.out.println(artist.getCredits().hashCode());
			}
		});
		System.out.println(artist.getCredits().hashCode());
		return artist.getCredits().stream().anyMatch(p ->true);
	}
	
	<S extends ArtistCredit , C extends Credit>  C transform(ArtistCredit ac , Supplier<C> supplier)
	{ 
		C target = supplier.get();
		target.setId(ac.getArtistCreditId());
		target.setCreditName(ac.getName());
		target.setCreditCount(ac.getArtistCount());
		return target;
	}
}
