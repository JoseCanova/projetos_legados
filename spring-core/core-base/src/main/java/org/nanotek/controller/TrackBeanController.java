package org.nanotek.controller;

import org.nanotek.base.maps.TrackBeanBaseMap;
import org.nanotek.beans.csv.TrackBean;
import org.nanotek.service.BaseService;
import org.nanotek.service.parser.TrackBeanParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.bytecode.opencsv.bean.CsvToBean;

@RestController
@RequestMapping(path = "/track_bean")
public class TrackBeanController extends BaseController<TrackBeanBaseMap , TrackBean, TrackBeanParser,BaseService<TrackBean,Long>>{

	private BaseService<TrackBean, Long> baseService;
	
	@Autowired
	@Qualifier("TrackBeanParser")
	private TrackBeanParser trackBeanParser;
	
	@Autowired
	@Qualifier("TrackBeanCsvToBean")
	private CsvToBean<TrackBean> csvToBean;
	
	@Override
	public TrackBeanBaseMap getBaseMap() {
		return trackBeanParser.getTrackBeanBaseMap();
	}

	@Override
	public CsvToBean<TrackBean> getCsvToBean() {
		return csvToBean;
	}

	@Override
	public TrackBeanParser getBaseParser() {
		return trackBeanParser;
	}

	@Override
	public BaseService<TrackBean, Long> getBaseService() {
		return baseService;
	}

	@Override
	@RequestMapping("/{id}")
	public TrackBean findById(@PathVariable(value="id") String id) {
		return  null;
	}

	
}
