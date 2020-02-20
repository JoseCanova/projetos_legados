package org.nanotek.controller;

import org.nanotek.Base;
import org.nanotek.controller.response.EntityResponseBase;
import org.nanotek.service.BaseService;

@FunctionalInterface
public interface EntityServiceResponseBase<T extends EntityResponseBase<?> , B extends Base , K , S extends BaseService<B,K>> 
extends ResponseServiceControllerBase<T , B , B , K , S > {
}
