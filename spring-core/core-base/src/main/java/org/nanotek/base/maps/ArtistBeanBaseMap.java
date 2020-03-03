package org.nanotek.base.maps;

import org.nanotek.beans.csv.ArtistBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;


@Component(value = "ArtistBeanBaseMap")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "artist")
public class ArtistBeanBaseMap extends BaseMapColumnStrategy<ArtistBean>{

	public ArtistBeanBaseMap() {
	}

}
