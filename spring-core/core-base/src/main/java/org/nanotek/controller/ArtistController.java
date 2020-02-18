package org.nanotek.controller;

import java.util.List;
import java.util.Optional;

import org.nanotek.beans.Artist;
import org.nanotek.service.jpa.ArtistJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistController  implements BaseController<Artist,ArtistJpaService> {


	@Autowired
	private ArtistJpaService baseService;
	
	@Override
	@RequestMapping("/{id}")
	public @ResponseBody  Artist findById(@PathVariable(value="id") String  id) {
		Optional<Artist> artistOpt = baseService.findById(Long.valueOf(id));
		return artistOpt.isPresent() ? artistOpt.get() : null;
	}

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