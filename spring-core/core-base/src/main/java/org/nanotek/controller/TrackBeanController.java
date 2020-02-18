package org.nanotek.controller;

import org.nanotek.beans.Track;
import org.nanotek.beans.csv.TrackBean;
import org.nanotek.service.BaseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/track")
public class TrackBeanController implements BaseController<Track, BaseService<Track,Long>>{

	private BaseService<TrackBean, Long> baseService;
	

	@Override
	@RequestMapping("/{id}")
	public Track findById(@PathVariable(value="id") String id) {
		return  null;
	}

	
}
