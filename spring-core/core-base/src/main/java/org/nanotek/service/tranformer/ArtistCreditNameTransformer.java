package org.nanotek.service.tranformer;

import java.util.Optional;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.ArtistCreditName;
import org.nanotek.beans.ArtistName;
import org.nanotek.beans.csv.ArtistCreditNameBean;
import org.nanotek.service.ArtistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistCreditNameTransformer implements Transformer<ArtistCreditNameBean,ArtistCreditName> {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	ArtistService artistService;
	
	@Override
	public ArtistCreditName transform(ArtistCreditNameBean i) {
		Optional<ArtistCreditName> ac = Optional.empty();
		Optional<ArtistCredit> artistCredit = Optional.empty();
		Optional <ArtistName> artistName = Optional.empty();
		log.info("ArtistCreditId " + i.getArtistCreditId());
		log.info("ArtistId " + i.getArtistId());
		if (i.getArtistCreditId() !=null)
			artistCredit = artistService.findByArtistCreditId(i.getArtistCreditId()); 
		if(i.getArtistId() !=null)
			artistName = artistService.findByArtistId(i.getArtistId());
		if(artistCredit.isPresent() && artistName.isPresent()) { 
			ac = Optional.of(populate(i , artistCredit , artistName));
		}
		return ac.isPresent() ? ac.get() : null;
	}


	private ArtistCreditName populate(ArtistCreditNameBean i, Optional<ArtistCredit> artistCredit,
			Optional<ArtistName> artistName) {
		ArtistCreditName ac = new ArtistCreditName();
		ac.setArtistCredit(artistCredit.get());
		ac.setArtistName(artistName.get());
		ac.setName(i.getName());
		ac.setJoinPhrase(i.getJoinPhrase());
		ac.setPosition(i.getPosition());
		return ac;
	}

}
