package org.nanotek.service.parser;

import org.nanotek.beans.ArtistName;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.bean.CsvToBean;

@Component
@DependsOn(value = {"ArtistBaseMap"})
public class ArtistCsvToBean extends CsvToBean<ArtistName>{
	
	
}
