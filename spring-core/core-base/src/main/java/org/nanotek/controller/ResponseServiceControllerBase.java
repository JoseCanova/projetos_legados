package org.nanotek.controller;

import org.nanotek.Base;
import org.nanotek.controller.response.ResponseBase;
import org.nanotek.service.BaseService;

@FunctionalInterface
public interface ResponseServiceControllerBase<R extends ResponseBase<?> , I , B extends Base , K , S extends BaseService<B,K>> extends ServiceControllerBase<R,B,K,S>{
}
