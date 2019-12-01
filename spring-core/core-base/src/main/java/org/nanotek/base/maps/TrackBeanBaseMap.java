package org.nanotek.base.maps;

import org.nanotek.beans.csv.TrackBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component(value = "TrackBeanBaseMap")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "trackbean")
public class TrackBeanBaseMap extends BaseMapColumnStrategy<TrackBean> {

	public TrackBeanBaseMap() { 
		super();
	}
	
}
