package org.nanotek.controller;

import org.nanotek.base.maps.RecordingBeanBaseMap;
import org.nanotek.beans.csv.RecordingBean;
import org.nanotek.service.BaseService;
import org.nanotek.service.parser.RecordingBeanParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.bytecode.opencsv.bean.CsvToBean;

@RestController
@RequestMapping(path = "/recording_bean")
public class RecordingBeanController extends BaseController<RecordingBeanBaseMap , RecordingBean, RecordingBeanParser,BaseService<RecordingBean,Long>>{

	
	private BaseService<RecordingBean, Long> baseService;
	
	@Autowired
	@Qualifier("RecordingBeanParser")
	private RecordingBeanParser recordingBeanParser;
	
	@Autowired
	@Qualifier("RecordingBeanCsvToBean")
	private CsvToBean<RecordingBean> csvToBean;

	@Override
	public RecordingBeanBaseMap getBaseMap() {
		return recordingBeanParser.getRecordingBeanBaseMap();
	}

	@Override
	public CsvToBean<RecordingBean> getCsvToBean() {
		return csvToBean;
	}

	@Override
	public RecordingBeanParser getBaseParser() {
		return recordingBeanParser;
	}

	@Override
	public BaseService<RecordingBean, Long> getBaseService() {
		return baseService;
	}

	@Override
	@RequestMapping("/{id}")
	public RecordingBean findById(@PathVariable(value="id") String id) {
		return null;
	}
	
}
