package org.nanotek.base.reader;

import java.io.File;
import java.io.FileReader;

import org.nanotek.base.maps.ArtistBaseMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVReader;

@Component
@DependsOn(value = {"ArtistBaseMap"})
public class ArtistReader implements InitializingBean{

	public CSVReader csvReader;
	
	@Autowired
	private ArtistBaseMap artistBaseMap;

	public CSVReader getCsvReader() {
		return csvReader;
	}

	public void setCsvReader(CSVReader csvReader) {
		this.csvReader = csvReader;
	}

	public ArtistBaseMap getArtistBaseMap() {
		return artistBaseMap;
	}

	public void setArtistBaseMap(ArtistBaseMap artisBaseMap) {
		this.artistBaseMap = artisBaseMap;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		StringBuffer fileLocationStr = new StringBuffer();
		fileLocationStr.append(artistBaseMap.getFileLocation())
							.append(System.getProperty("file.separator"));
		FileReader fileReader = new FileReader(new File(fileLocationStr.toString()));
		csvReader = new CSVReader(fileReader , '\t');
	}
	
}
