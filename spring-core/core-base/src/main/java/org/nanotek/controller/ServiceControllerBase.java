package org.nanotek.controller;

import org.nanotek.Base;
import org.nanotek.service.BaseService;

@FunctionalInterface
public interface ServiceControllerBase<I , B extends Base , K , S extends BaseService<?,K>> extends ServiceController<S,I,K> {
}
