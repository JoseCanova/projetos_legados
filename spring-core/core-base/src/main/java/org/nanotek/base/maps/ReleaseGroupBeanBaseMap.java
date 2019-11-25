package org.nanotek.base.maps;

import org.nanotek.beans.csv.ReleaseGroupBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component(value = "ReleaseGroupBeanBaseMap")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "releasegroup")
public class ReleaseGroupBeanBaseMap extends BaseMapColumnStrategy<ReleaseGroupBean>{
	public ReleaseGroupBeanBaseMap() { 
		super();
	}
}
