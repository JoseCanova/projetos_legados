package org.nanotek.service.parser;

import org.nanotek.base.maps.ArtistCreditBaseMap;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value = "ArtistCreditParser")
@DependsOn(value = {"ArtistCreditBaseMap"})
public class ArtistCreditParser extends BaseParser{

	@Autowired
	private ArtistCreditBaseMap artistCreditBaseMap;
	
	public ArtistCreditParser() {}
	
	
	@Override
	public BaseMapColumnStrategy<?> getBaseMap() {
		return artistCreditBaseMap;
	}



	public ArtistCreditBaseMap getArtistCreditBaseMap() {
		return artistCreditBaseMap;
	}



	public void setArtistCreditBaseMap(ArtistCreditBaseMap artistCreditBaseMap) {
		this.artistCreditBaseMap = artistCreditBaseMap;
	}

}
