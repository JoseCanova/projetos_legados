package org.nanotek.controller.entity;

import org.nanotek.beans.entity.BrainzBaseEntity;
import org.nanotek.service.BaseService;

public interface EntityNameBaseResponseController<B extends BrainzBaseEntity<B>> extends BaseService<B>{
	
	BaseService<B> getBaseService();
}
