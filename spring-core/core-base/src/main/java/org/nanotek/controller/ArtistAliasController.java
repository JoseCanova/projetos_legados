package org.nanotek.controller;

import org.nanotek.base.maps.ArtistAliasBaseMap;
import org.nanotek.beans.ArtistAlias;
import org.nanotek.service.parser.ArtistAliasParser;
import org.nanotek.service.parser.BaseParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.bytecode.opencsv.bean.CsvToBean;

@RestController
@RequestMapping("/artist_alias")
public class ArtistAliasController extends BaseController<ArtistAliasBaseMap , ArtistAlias> {

	@Autowired 
	@Qualifier("ArtistAliasBaseMap")
	private ArtistAliasBaseMap baseMap;
	
	@Autowired
	@Qualifier("ArtistAliasParser")
	private ArtistAliasParser baseParser;
	
	@Autowired
	@Qualifier("ArtistAliasCsvToBean")
	private CsvToBean<ArtistAlias> csvToBean;
	
	public CsvToBean<ArtistAlias> getCsvToBean() {
		return csvToBean;
	}

	public ArtistAliasBaseMap getBaseMap() {
		return baseMap;
	}

	@Override
	public BaseParser getBaseParser() {
		return baseParser;
	}
	
}
