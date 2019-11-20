package org.nanotek.controller;

import org.nanotek.Result;
import org.nanotek.base.maps.ArtistBaseMap;
import org.nanotek.beans.ArtistName;
import org.nanotek.service.parser.ArtistParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.bytecode.opencsv.bean.CsvToBean;

@RestController
@RequestMapping("/artist")
public class ArtistController  extends BaseController<ArtistBaseMap , ArtistName,ArtistParser> {

	@Autowired
	@Qualifier("ArtistParser")
	private ArtistParser artistParser;
	
	@Autowired
	@Qualifier("ArtistCsvToBean")
	private CsvToBean<ArtistName> csvToBean;
	
	
    /* here is spring integration */
    public Result process() { 
    	return null;
    }

	@Override
	public ArtistBaseMap getBaseMap() {
		return  artistParser.getArtistBaseMap();
	}

	@Override
	public CsvToBean<ArtistName> getCsvToBean() {
		return csvToBean;
	}

	@Override
	public ArtistParser getBaseParser() {
		return artistParser;
	}
    
}