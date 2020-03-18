package org.nanotek.controller.entity;

import org.nanotek.beans.entity.Area;
import org.nanotek.controller.response.IterableResponseEntity;
import org.nanotek.service.jpa.AreaJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/area")
public class AreaController  implements  EntityNameBaseResponseController<Area> {


	@Autowired
	private AreaJpaService baseService;
	

	@RequestMapping("/name/{name}")
	public IterableResponseEntity<Iterable<Area>, Area> findByNameContainingIgnoreCase(@PathVariable(value="name") String  name) {
		Iterable<Area> it = getBaseService().findByNameContainingIgnoreCase(name);
		return IterableResponseEntity.fromIterable(it, HttpStatus.OK);
	}

	public AreaJpaService getBaseService() {
		return baseService;
	}
	
}