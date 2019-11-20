package org.nanotek.service.parser;

import org.nanotek.base.maps.ArtistAliasBaseMap;
import org.nanotek.base.maps.ArtistBaseMap;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value = "ArtistAliasParser")
@DependsOn({"ArtistAliasBaseMap"})
public class ArtistAliasParser extends BaseParser{

	@Autowired
	private ArtistAliasBaseMap artistBaseMap;


	public ArtistAliasBaseMap getArtistBaseMap() {
		return artistBaseMap;
	}


	public void setArtistBaseMap(ArtistAliasBaseMap artistBaseMap) {
		this.artistBaseMap = artistBaseMap;
	}


	@Override
	public BaseMapColumnStrategy<?> getBaseMap() {
		return artistBaseMap;
	}
}
