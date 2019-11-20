package org.nanotek.base.maps;

import org.nanotek.beans.ArtistCredit;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component(value = "ArtistCreditBaseMap")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "artistcredit")
public class ArtistCreditBaseMap extends BaseMapColumnStrategy<ArtistCredit>{

	public ArtistCreditBaseMap () { 
		super();
	}
	
}
