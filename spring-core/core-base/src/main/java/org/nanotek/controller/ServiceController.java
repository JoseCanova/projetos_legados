package org.nanotek.controller;

import org.nanotek.service.BaseService;

@FunctionalInterface
public interface ServiceController<S extends BaseService<?,K>,I,K> extends BaseController<K , I> {
}
