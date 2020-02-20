package org.nanotek.controller.entity;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.nanotek.service.jpa.BasePersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist_credit")
public class ArtistCreditController  implements  EntityResponseController<ArtistCredit, Long> {

	@Autowired
	ArtistCreditJpaService baseService;

	@Override
	public BasePersistenceService<ArtistCredit, Long> getBaseService() {
		return baseService;
	}

}
