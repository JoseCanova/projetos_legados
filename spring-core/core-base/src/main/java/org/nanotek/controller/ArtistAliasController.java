package org.nanotek.controller;

import org.nanotek.beans.ArtistAlias;
import org.nanotek.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist_alias")
public class ArtistAliasController implements BaseController<ArtistAlias , BaseService<ArtistAlias,Long>> {
	

	@Override
	public ArtistAlias findById(String id) {
		return null;
	}

}
