package org.nanotek.base.maps;

import org.nanotek.beans.ArtistCreditName;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component(value = "ArtistCreditNameBaseMap")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "artistcreditname")
public class ArtistCreditNameBaseMap extends BaseMapColumnStrategy<ArtistCreditName> {

	public ArtistCreditNameBaseMap() {
		super();
	}
}
