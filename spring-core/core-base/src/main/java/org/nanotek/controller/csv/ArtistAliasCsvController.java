package org.nanotek.controller.csv;

import org.nanotek.base.maps.ArtistAliasBaseMap;
import org.nanotek.beans.ArtistAlias;
import org.nanotek.service.parser.ArtistAliasParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.bytecode.opencsv.bean.CsvToBean;

@RestController
@RequestMapping("/csv/artist_alias")
public class ArtistAliasCsvController extends CsvController<ArtistAliasBaseMap , ArtistAlias, ArtistAliasParser> {

	@Autowired
	@Qualifier("ArtistAliasParser")
	private ArtistAliasParser baseParser;
	
	@Autowired
	@Qualifier("ArtistAliasCsvToBean")
	private CsvToBean<ArtistAlias> csvToBean;
	
	public CsvToBean<ArtistAlias> getCsvToBean() {
		return csvToBean;
	}

	@Override
	public ArtistAliasParser getBaseParser() {
		return baseParser;
	}

	@Override
	public ArtistAliasBaseMap getBaseMap() {
		return baseParser.getArtistBaseMap();
	}

}
