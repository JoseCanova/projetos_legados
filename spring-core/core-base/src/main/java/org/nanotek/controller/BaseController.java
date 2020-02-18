package org.nanotek.controller;

import java.util.List;

import org.nanotek.Base;
import org.nanotek.service.BaseService;

public interface  BaseController<I extends Base, S extends BaseService<I,?>> {

    I findById( String id) ;

    public default List<I> findByExample(String id , String attr) {
    	return null;
    }

}
