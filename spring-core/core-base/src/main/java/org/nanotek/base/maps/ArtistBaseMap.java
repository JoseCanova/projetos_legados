package org.nanotek.base.maps;

import org.nanotek.beans.ArtistName;
import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.MapColumnStrategy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;


@Component(value = "ArtistBaseMap")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "artist")
public class ArtistBaseMap extends MapColumnStrategy<BaseMap<ArtistName>, ArtistName>{

	private static final long serialVersionUID = 2528373300321092539L;

	public String fileLocation; 
	
	public String fileName;
	
	public ArtistBaseMap() {
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
