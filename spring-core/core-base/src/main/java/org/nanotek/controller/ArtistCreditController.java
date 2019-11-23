package org.nanotek.controller;

import org.nanotek.base.maps.ArtistCreditBaseMap;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.service.BaseService;
import org.nanotek.service.parser.ArtistCreditParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.bytecode.opencsv.bean.CsvToBean;

@RestController
@RequestMapping("/artist_credit")
public class ArtistCreditController extends BaseController<ArtistCreditBaseMap , ArtistCredit, ArtistCreditParser, BaseService<ArtistCredit,Long>>{

	@Autowired
	@Qualifier("ArtistCreditParser")
	private ArtistCreditParser artistParser;
	
	@Autowired
	@Qualifier("ArtistCreditCsvToBean")
	private CsvToBean<ArtistCredit> csvToBean;

	
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
	public BaseService<ArtistCredit,Long> getBaseService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArtistCredit findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
