package org.nanotek.controller.entity;

import org.nanotek.service.BaseService;

public interface EntityNameBaseResponseController<B>{
	
	BaseService<B,?> getBaseService();
}
