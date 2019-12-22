package org.nanotek.controller;

import org.nanotek.base.maps.ArtistCreditNameBeanBaseMap;
import org.nanotek.beans.csv.ArtistCreditNameBean;
import org.nanotek.service.BaseService;
import org.nanotek.service.parser.ArtistCreditNameBeanParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.bytecode.opencsv.bean.CsvToBean;

//ArtistCreditNameCsvToBean
@RestController
@RequestMapping(path = "artist_credit_name_bean")
public class ArtistCreditNameBeanController  extends BaseController<ArtistCreditNameBeanBaseMap , ArtistCreditNameBean, ArtistCreditNameBeanParser,BaseService<ArtistCreditNameBean,Long>>{

//	@Autowired
	private BaseService<ArtistCreditNameBean, Long> baseService;

	@Autowired
	@Qualifier("ArtistCreditNameBeanParser")
	private ArtistCreditNameBeanParser artistParser;

	@Autowired
	@Qualifier("ArtistCreditNameBeanCsvToBean")
	private CsvToBean<ArtistCreditNameBean> csvToBean;

	@Override
	public ArtistCreditNameBeanBaseMap getBaseMap() {
		return artistParser.getArtistCreditNameBeanBaseMap();
	}

	@Override
	public CsvToBean<ArtistCreditNameBean> getCsvToBean() {
		return csvToBean;
	}

	@Override
	public ArtistCreditNameBeanParser getBaseParser() {
		return artistParser;
	}

	@Override
	public BaseService<ArtistCreditNameBean, Long> getBaseService() {
		return baseService;
	}

	@Override
	@RequestMapping("/{id}")
	public ArtistCreditNameBean findById(@PathVariable(value="id") String id) {
		return  null;
	}

}
