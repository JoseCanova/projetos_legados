package org.nanotek.controller;

import org.nanotek.beans.Recording;
import org.nanotek.service.BaseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/recording")
public class RecordingBeanController implements BaseController<Recording, BaseService<Recording,Long>>{

	
	private BaseService<Recording, Long> baseService;
	
	@Override
	@RequestMapping("/{id}")
	public Recording findById(@PathVariable(value="id") String id) {
		return null;
	}
	
}
