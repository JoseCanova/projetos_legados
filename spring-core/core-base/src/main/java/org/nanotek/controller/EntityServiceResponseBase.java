package org.nanotek.controller;

import org.nanotek.Base;
import org.nanotek.controller.response.EntityResponseBase;
import org.nanotek.controller.response.ResponseBase;
import org.nanotek.service.BaseService;
import org.springframework.http.ResponseEntity;

@FunctionalInterface
public interface EntityServiceResponseBase<T extends ResponseBase<?> , B extends Base , K , S extends BaseService<B,K>> 
extends ResponseServiceControllerBase<T , B , B , K , S > {
}
