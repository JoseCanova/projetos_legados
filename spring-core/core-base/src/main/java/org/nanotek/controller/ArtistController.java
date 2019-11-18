package org.nanotek.controller;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.nanotek.Result;
import org.nanotek.base.maps.ArtistBaseMap;
import org.nanotek.beans.ArtistName;
import org.nanotek.service.parser.ArtistCsvToBean;
import org.nanotek.service.parser.ArtistParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistController {

	@Autowired 
	private ArtistBaseMap artistBaseMap; 
	
	@Autowired
	private ArtistParser artistParser;
	
	@Autowired
	private ArtistCsvToBean artistCsvToBean;
	
	
    @RequestMapping("/map_config")
    public ArtistBaseMap mapConfig(@RequestParam(value="count", defaultValue="1") Long count) {
        return artistBaseMap;
    }
    
    @RequestMapping("/load")
    public List<ArtistName> load(@RequestParam(value="count", defaultValue="1") Long count) throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException, IntrospectionException {
    	List<ArtistName> artists = new  ArrayList<ArtistName>();
    	int i = 0;
    	while (i < count) { 
    		String[] instanceArray = artistParser.readNext();
    		ArtistName artistName = artistCsvToBean.processLine(artistBaseMap, instanceArray);
    		artists.add(artistName);
    		i++;
    	}
    	return artists;
    }
    
    /* here is spring integration */
    public Result process() { 
    	return null;
    }
    
    
}