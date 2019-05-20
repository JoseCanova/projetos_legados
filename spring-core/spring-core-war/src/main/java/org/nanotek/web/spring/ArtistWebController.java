package org.nanotek.web.spring;

import org.nanotek.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/artists")
public class ArtistWebController {

	@Autowired
	private ArtistService artistService; 
	
	@RequestMapping(value="/artists" , method=RequestMethod.GET)
	public String list()
	{ 
		return null;
	}
}
