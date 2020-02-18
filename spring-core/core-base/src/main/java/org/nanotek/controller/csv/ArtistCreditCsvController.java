package org.nanotek.controller.csv;

import org.nanotek.base.maps.ArtistCreditBaseMap;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.service.parser.ArtistCreditParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.bytecode.opencsv.bean.CsvToBean;

@RestController
@RequestMapping("/csv/artist_credit")
public class ArtistCreditCsvController extends CsvController<ArtistCreditBaseMap , ArtistCredit, ArtistCreditParser>
{

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

}
