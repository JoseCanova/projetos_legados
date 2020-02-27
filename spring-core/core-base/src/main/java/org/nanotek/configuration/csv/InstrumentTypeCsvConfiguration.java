package org.nanotek.configuration.csv;

import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.nanotek.beans.csv.InstrumentTypeBean;
import org.nanotek.controller.csv.CsvBaseController;
import org.nanotek.service.parser.BaseMapParser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.bytecode.opencsv.bean.CsvToBean;

@Configuration
@EnableConfigurationProperties
public class InstrumentTypeCsvConfiguration {

	private static final String CONTROLLER_BASE_MAPPING = "/csv/instrument";
	
	public InstrumentTypeCsvConfiguration() {
	}

	@Bean
	@ConfigurationProperties(prefix = "instrumenttype")
	BaseMapColumnStrategy<InstrumentTypeBean> intrumentTypeBaseMap(){ 
		return new BaseMapColumnStrategy<>();
	}
	
	@Bean
	CsvToBean<InstrumentTypeBean> instrumentTypeCsvToBean() {
		return new CsvToBean<>();
	}
	
	@Bean
	BaseMapParser<InstrumentTypeBean> parser() { 
		return new BaseMapParser<>(intrumentTypeBaseMap());
	}
	
	@RestController
	@RequestMapping(CONTROLLER_BASE_MAPPING)
	class CsvRestController extends CsvBaseController<InstrumentTypeBean, BaseMapParser<InstrumentTypeBean>>{ 
		public CsvRestController(BaseMapParser<InstrumentTypeBean> parser, CsvToBean<InstrumentTypeBean> csvToBean) {
			super(parser, csvToBean);
		}
	}
	
}
