package org.nanotek.controller;

import org.nanotek.base.maps.ReleaseBeanBaseMap;
import org.nanotek.beans.csv.ReleaseBean;
import org.nanotek.service.BaseService;
import org.nanotek.service.parser.ReleaseBeanParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.bytecode.opencsv.bean.CsvToBean;

@RestController
@RequestMapping(path = "/release_bean")
public class ReleaseBeanController extends BaseController<ReleaseBeanBaseMap , ReleaseBean, ReleaseBeanParser,BaseService<ReleaseBean,Long>>{

	private BaseService<ReleaseBean, Long> baseService;
	
	@Autowired
	@Qualifier("ReleaseBeanParser")
	private ReleaseBeanParser releaseBeanParser;
	
	@Autowired
	@Qualifier("ReleaseBeanCsvToBean")
	private CsvToBean<ReleaseBean> csvToBean;
	
	@Override
	public ReleaseBeanBaseMap getBaseMap() {
		return releaseBeanParser.getReleaseBeanBaseMap();
	}

	@Override
	public CsvToBean<ReleaseBean> getCsvToBean() {
		return csvToBean;
	}

	@Override
	public ReleaseBeanParser getBaseParser() {
		return releaseBeanParser;
	}

	@Override
	public BaseService<ReleaseBean, Long> getBaseService() {
		return baseService;
	}

	@Override
	@RequestMapping("/{id}")
	public ReleaseBean findById(@PathVariable(value="id") String id) {
		return  null;
	}

	
}
