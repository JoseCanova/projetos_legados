package org.nanotek.service.tranformer;

import java.util.Optional;

import org.nanotek.Transformer;
import org.nanotek.beans.csv.ReleaseBean;
import org.nanotek.beans.entity.ArtistCredit;
import org.nanotek.beans.entity.Release;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier(value="ReleaseTransformerOld")
public class ReleaseTransformer implements Transformer<ReleaseBean , Release> {

	@Autowired 
	private ArtistCreditJpaService creditJpaService;
	
	@Override
	public Release transform(ReleaseBean i) {
		return null;
	}

	@Transactional
	private Optional<ArtistCredit> findArtistCredit(Long artistCreditId) {
		return creditJpaService.findById(artistCreditId);
	}

}
