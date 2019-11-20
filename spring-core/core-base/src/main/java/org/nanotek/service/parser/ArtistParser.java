package org.nanotek.service.parser;

import java.io.IOException;
import java.util.List;

import org.nanotek.base.maps.ArtistBaseMap;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
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

	public List<String[]> readAll() throws IOException {
		return csvReader.readAll();
	}

	public String[] readNext() throws IOException {
		return csvReader.readNext();
	}

	@Override
	public void close() throws IOException {
		csvReader.close();
	}

	@Override
	public BaseMapColumnStrategy<?> getBaseMap() {
		return artistBaseMap;
	}
	
}
