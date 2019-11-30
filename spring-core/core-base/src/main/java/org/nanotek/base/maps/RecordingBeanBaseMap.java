package org.nanotek.base.maps;

import org.nanotek.beans.csv.RecordingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component(value = "RecordingBeanBaseMap")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "recordingbean")
public class RecordingBeanBaseMap extends BaseMapColumnStrategy<RecordingBean>{
	public RecordingBeanBaseMap() { 
		super();
	}
}
