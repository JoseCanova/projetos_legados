package org.nanotek.controller.entity;

import org.nanotek.entities.MutableNameBase;
import org.nanotek.repository.jpa.EntityNameBaseRepository;

public interface EntityNameBaseResponseController< E extends MutableNameBase<?> , R extends EntityNameBaseRepository<E, Long>> extends EntityResponseController<E,R>{
}
