package org.nanotek.base.maps;

import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.MapColumnStrategy;
import org.nanotek.ws.xml.Artist;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "artist_map_component")
public class ArtistBaseMap extends MapColumnStrategy<BaseMap<Artist>, Artist>{

	private static final long serialVersionUID = 2528373300321092539L;

	public String fileLocation; 
	
	public String fileName;
	
	public ArtistBaseMap() {
	}
}
