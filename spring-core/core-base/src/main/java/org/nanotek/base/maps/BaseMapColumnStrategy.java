package org.nanotek.base.maps;

import org.nanotek.IdBase;
import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.MapColumnStrategy;


public class BaseMapColumnStrategy<T extends BaseMap<T,Class<ID>> , ID extends IdBase<?, ?>> 
extends MapColumnStrategy<T> implements   IdBase<T,Class<ID>>{

	private static final long serialVersionUID = -7318639218365616230L;

	public Class<ID> id;
	
	public String fileLocation; 
	
	public String fileName;
	
	public BaseMapColumnStrategy() {
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

	@Override
	public Class<ID> getId() {
		return id;
	}

}
