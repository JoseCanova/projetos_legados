package org.nanotek.controller;

import org.nanotek.base.maps.ArtistCreditNameBaseMap;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.ArtistCreditName;
import org.nanotek.service.parser.ArtistCreditNameParser;
import org.nanotek.service.parser.ArtistCreditParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.bytecode.opencsv.bean.CsvToBean;

//ArtistCreditNameCsvToBean
@RestController
@RequestMapping(path = "artist_credit_name")
public class ArtistCreditNameController  extends BaseController<ArtistCreditNameBaseMap , ArtistCreditName, ArtistCreditNameParser>{

	@Autowired
	@Qualifier("ArtistCreditNameParser")
	private ArtistCreditNameParser artistParser;
	
	@Autowired
	@Qualifier("ArtistCreditNameCsvToBean")
	private CsvToBean<ArtistCreditName> csvToBean;
	
	@Override
	public ArtistCreditNameBaseMap getBaseMap() {
		return artistParser.getArtistCreditNameBaseMap();
	}

	@Override
	public CsvToBean<ArtistCreditName> getCsvToBean() {
		return csvToBean;
	}

	@Override
	public ArtistCreditNameParser getBaseParser() {
		return artistParser;
	}

}
