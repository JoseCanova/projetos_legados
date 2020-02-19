package org.nanotek.controller;

import java.util.Optional;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist_credit")
public class ArtistCreditController implements BaseController<ArtistCredit, ArtistCreditJpaService>{

	
	@Autowired
	ArtistCreditJpaService baseService;
	

	@RequestMapping("/{id}")
	public @ResponseBody  ArtistCredit findById(@PathVariable(value="id") String  id) {
		Optional<ArtistCredit> artistOpt = baseService.findById(Long.valueOf(id));
		return artistOpt.isPresent() ? artistOpt.get() : null;
	}

}
