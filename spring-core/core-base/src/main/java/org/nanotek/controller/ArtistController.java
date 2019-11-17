package org.nanotek.controller;

import org.nanotek.base.maps.ArtistBaseMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistController {

	@Autowired 
	ArtistBaseMap artistBaseMap; 
	
    @RequestMapping("/map_config")
    public ArtistBaseMap greeting(@RequestParam(value="count", defaultValue="1") Long count) {
        return artistBaseMap;
    }
}