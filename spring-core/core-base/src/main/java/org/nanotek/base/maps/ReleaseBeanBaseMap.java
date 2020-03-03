package org.nanotek.base.maps;

import org.nanotek.beans.csv.ReleaseBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component(value = "ReleaseBeanBaseMap")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "releasebean")
public class ReleaseBeanBaseMap extends BaseMapColumnStrategy<ReleaseBean>{
	public ReleaseBeanBaseMap() { 
		super();
	}
}
