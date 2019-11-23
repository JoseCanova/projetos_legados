package org.nanotek.controller;

import java.util.List;
import java.util.Optional;

import org.nanotek.Result;
import org.nanotek.base.maps.ArtistBaseMap;
import org.nanotek.beans.ArtistName;
import org.nanotek.service.jpa.ArtistNameJpaService;
import org.nanotek.service.parser.ArtistParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.bytecode.opencsv.bean.CsvToBean;

@RestController
@RequestMapping("/artist")
public class ArtistController  extends BaseController<ArtistBaseMap , ArtistName,ArtistParser,ArtistNameJpaService> {

	@Autowired
	@Qualifier("ArtistParser")
	private ArtistParser artistParser;

	@Autowired
	@Qualifier("ArtistCsvToBean")
	private CsvToBean<ArtistName> csvToBean;

	@Autowired
	private ArtistNameJpaService baseService;

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

	@Override
	public ArtistNameJpaService getBaseService() {
		return baseService;
	}

	@Override
	@RequestMapping("/{id}")
	public @ResponseBody  ArtistName findById(@PathVariable(value="id") String  id) {
		Optional<ArtistName> artistOpt = baseService.findById(Long.valueOf(id));
		return artistOpt.isPresent() ? artistOpt.get() : null;
	}
	
	@RequestMapping("/artistId/{id}")
	public @ResponseBody  List<ArtistName> findByArtistId(@PathVariable(value="id") String  id) {
		return baseService.findByArtistId(Long.valueOf(id));
	}

}