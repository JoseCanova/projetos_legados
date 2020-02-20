package org.nanotek.controller.entity;

import java.util.List;

import org.nanotek.beans.Artist;
import org.nanotek.service.jpa.ArtistJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistController  implements  EntityResponseController<Artist, Long> {


	@Autowired
	private ArtistJpaService baseService;
	

	@RequestMapping("/artistId/{id}")
	public @ResponseBody  List<Artist> findByArtistId(@PathVariable(value="id") String  id) {
		return getBaseService().findByArtistId(Long.valueOf(id));
	}

	@RequestMapping("/artist_name/{name}")
	public @ResponseBody  List<Artist> findByName(@PathVariable(value="name") String  name) {
		return getBaseService().findByNameContaining(name);
	}

	public ArtistJpaService getBaseService() {
		return baseService;
	}
	
}