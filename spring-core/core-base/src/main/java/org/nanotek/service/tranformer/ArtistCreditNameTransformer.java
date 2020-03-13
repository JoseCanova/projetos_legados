package org.nanotek.service.tranformer;

import java.util.Optional;

import org.nanotek.Transformer;
import org.nanotek.beans.csv.ArtistCreditNameBean;
import org.nanotek.beans.entity.Artist;
import org.nanotek.beans.entity.ArtistCredit;
import org.nanotek.beans.entity.ArtistCreditName;
import org.nanotek.service.ArtistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistCreditNameTransformer implements Transformer<ArtistCreditNameBean,ArtistCreditName> {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	ArtistService artistService;

	@Override
	@Transactional
	public ArtistCreditName transform(ArtistCreditNameBean i) {
		Optional<ArtistCreditName> ac = Optional.empty();
		Optional<ArtistCredit> artistCredit = Optional.empty();
		Optional <Artist> Artist = Optional.empty();
		log.info("ArtistCreditId " + i.getArtistCreditId());
		log.info("ArtistId " + i.getArtistId());
		if (i.getArtistCreditId() !=null)
			artistCredit = artistService.findByArtistCreditId(i.getArtistCreditId()); 
		if(i.getArtistId() !=null) {
			Optional<Artist> opt = artistService.findByArtistId(i.getArtistId());
			Artist = opt.isPresent() ? opt : null;
		}
		ac = Optional.of(populate(i , artistCredit , Artist));
		return ac.isPresent() ? ac.get() : null;
	}


	private ArtistCreditName populate(ArtistCreditNameBean i, 
			Optional<ArtistCredit> artistCredit,
			Optional<Artist> Artist) {
		ArtistCreditName ac = new ArtistCreditName();
		if (artistCredit !=null && artistCredit.isPresent())
			ac.setArtistCredit(artistCredit.get());
		if(Artist != null && Artist.isPresent()) {
			ac.setArtist(Artist.get());
		}
		ac.setName(i.getName());
		ac.setJoinPhrase(i.getJoinPhrase());
		ac.setPosition(i.getPosition());
		return ac;
	}

}
