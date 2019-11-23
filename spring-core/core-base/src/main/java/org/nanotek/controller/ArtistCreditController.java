package org.nanotek.controller;

import java.util.Optional;

import org.nanotek.base.maps.ArtistCreditBaseMap;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.nanotek.service.parser.ArtistCreditParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.bytecode.opencsv.bean.CsvToBean;

@RestController
@RequestMapping("/artist_credit")
public class ArtistCreditController extends BaseController<ArtistCreditBaseMap , ArtistCredit, ArtistCreditParser, ArtistCreditJpaService>{

	@Autowired
	@Qualifier("ArtistCreditParser")
	private ArtistCreditParser artistParser;
	
	@Autowired
	@Qualifier("ArtistCreditCsvToBean")
	private CsvToBean<ArtistCredit> csvToBean;

	@Autowired
	ArtistCreditJpaService baseService;
	
	@Override
	public ArtistCreditBaseMap getBaseMap() {
		return artistParser.getArtistCreditBaseMap();
	}

	@Override
	public CsvToBean<ArtistCredit> getCsvToBean() {
		return csvToBean;
	}

	@Override
	public ArtistCreditParser getBaseParser() {
		return artistParser;
	}

	@Override
	@RequestMapping("/{id}")
	public @ResponseBody  ArtistCredit findById(@PathVariable(value="id") String  id) {
		Optional<ArtistCredit> artistOpt = baseService.findById(Long.valueOf(id));
		return artistOpt.isPresent() ? artistOpt.get() : null;
	}

	@Override
	public ArtistCreditJpaService getBaseService() {
		return baseService;
	}

}
