package org.nanotek.base.maps;

import org.nanotek.beans.ArtistName;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;


@Component(value = "ArtistBaseMap")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "artist")
public class ArtistBaseMap extends BaseMapColumnStrategy<ArtistName>{

	private static final long serialVersionUID = 2528373300321092539L;

	public ArtistBaseMap() {
	}

}
