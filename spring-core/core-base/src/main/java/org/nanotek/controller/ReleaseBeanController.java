package org.nanotek.controller;

import org.nanotek.beans.Release;
import org.nanotek.beans.csv.ReleaseBean;
import org.nanotek.service.BaseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/release")
public class ReleaseBeanController implements BaseController<Release, BaseService<Release,Long>>{

	private BaseService<ReleaseBean, Long> baseService;
	

	@Override
	@RequestMapping("/{id}")
	public Release findById(@PathVariable(value="id") String id) {
		return  null;
	}

	
}
