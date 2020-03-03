package org.nanotek.base.maps;

import org.nanotek.beans.csv.MediumBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component(value = "MediumBeanBaseMap")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "mediumbean")
public class MediumBeanBaseMap extends BaseMapColumnStrategy<MediumBean>{
	
	public MediumBeanBaseMap() { 
		super();
	}

}
