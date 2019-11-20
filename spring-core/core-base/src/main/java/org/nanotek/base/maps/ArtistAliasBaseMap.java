package org.nanotek.base.maps;

import org.nanotek.beans.ArtistAlias;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component(value = "ArtistAliasBaseMap")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "artistalias")
public class ArtistAliasBaseMap extends BaseMapColumnStrategy<ArtistAlias>{

	
	public ArtistAliasBaseMap() {
	}
	
	
}
