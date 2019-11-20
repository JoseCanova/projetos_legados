package org.nanotek.service.parser;

import org.nanotek.base.maps.ArtistBaseMap;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value = "ArtistParser")
@DependsOn(value = {"ArtistBaseMap"})
public class ArtistParser extends BaseParser {

	@Autowired
	private ArtistBaseMap artistBaseMap;

	public ArtistBaseMap getArtistBaseMap() {
		return artistBaseMap;
	}

	public void setArtistBaseMap(ArtistBaseMap artisBaseMap) {
		this.artistBaseMap = artisBaseMap;
	}

	@Override
	public BaseMapColumnStrategy<?> getBaseMap() {
		return artistBaseMap;
	}
	
}
