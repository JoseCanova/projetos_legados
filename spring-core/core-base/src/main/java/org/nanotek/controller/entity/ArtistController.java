package org.nanotek.controller.entity;

import java.util.List;

import org.nanotek.beans.entity.Artist;
import org.nanotek.controller.response.IterableResponseEntity;
import org.nanotek.service.jpa.ArtistJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistController  implements  EntityResponseController<Artist, Long> {


	@Autowired
	private ArtistJpaService baseService;
	

	@RequestMapping("/name/{name}")
	public IterableResponseEntity<List<Artist>, Artist> findByName(@PathVariable(value="name") String  name) {
		List<Artist> list = getBaseService().findByNameContaining(name);
		return IterableResponseEntity.fromIterable(list, HttpStatus.OK);
	}

	public ArtistJpaService getBaseService() {
		return baseService;
	}
	
}