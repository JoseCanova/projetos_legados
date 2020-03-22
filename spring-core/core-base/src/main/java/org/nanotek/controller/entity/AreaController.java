package org.nanotek.controller.entity;

import org.checkerframework.checker.units.qual.K;
import org.nanotek.beans.entity.Area;
import org.nanotek.controller.response.IterableResponseEntity;
import org.nanotek.service.jpa.AreaJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/area")
public class AreaController<K extends Area<K>>  implements  EntityNameBaseResponseController<K> {



	
}