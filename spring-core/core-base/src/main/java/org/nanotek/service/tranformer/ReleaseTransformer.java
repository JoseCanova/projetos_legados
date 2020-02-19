package org.nanotek.service.tranformer;

import java.util.Optional;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.Release;
import org.nanotek.beans.csv.ReleaseBean;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReleaseTransformer implements Transformer<ReleaseBean , Release> {

	@Autowired 
	private ArtistCreditJpaService creditJpaService;
	
	@Override
	public Release transform(ReleaseBean i) {
		Release release = new Release(); 
		release.setReleaseId(i.getId());
		release.setBarCode(i.getBarcode());
//		release.setCountry(i.getLanguage());
		release.setName(i.getName());
		release.setGid(i.getGid());
		release.setReleaseGroup(i.getReleaseGroup());
		release.setStatus(i.getStatus() != null ? i.getStatus().toString() : null);
		Optional<ArtistCredit> opt = findArtistCredit(i.getArtistCreditId());
		if (opt.isPresent())
			release.setArtistCreditReference(opt.get());
		return release;
	}

	@Transactional
	private Optional<ArtistCredit> findArtistCredit(Long artistCreditId) {
		return creditJpaService.findById(artistCreditId);
	}

}
