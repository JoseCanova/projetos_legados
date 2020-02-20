package org.nanotek.controller.entity;

import org.nanotek.beans.ArtistAlias;
import org.nanotek.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist_alias")
public class ArtistAliasController implements BaseController<String , ArtistAlias> {
	

	@Override
	public ArtistAlias get(String id) {
		return null;
	}

}
