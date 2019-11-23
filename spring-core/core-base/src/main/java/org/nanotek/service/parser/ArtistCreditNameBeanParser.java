package org.nanotek.service.parser;

import org.nanotek.base.maps.ArtistCreditNameBeanBaseMap;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value = "ArtistCreditNameBeanParser")
public class ArtistCreditNameBeanParser extends BaseParser{

	@Autowired
	private ArtistCreditNameBeanBaseMap artistCreditNameBeanBaseMap;
	
	public ArtistCreditNameBeanParser() {}
	
	
	@Override
	public BaseMapColumnStrategy<?> getBaseMap() {
		return artistCreditNameBeanBaseMap;
	}


	public ArtistCreditNameBeanBaseMap getArtistCreditNameBeanBaseMap() {
		return artistCreditNameBeanBaseMap;
	}


	public void setArtistCreditNameBeanBaseMap(ArtistCreditNameBeanBaseMap artistCreditNameBeanBaseMap) {
		this.artistCreditNameBeanBaseMap = artistCreditNameBeanBaseMap;
	}

}
