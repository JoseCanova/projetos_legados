package org.nanotek.controller.entity;

import org.nanotek.MutableNameBase;
import org.nanotek.repository.jpa.EntityNameBaseRepository;

public interface EntityNameBaseResponseController< E extends MutableNameBase<Long,?> , R extends EntityNameBaseRepository<E, Long>> extends EntityResponseController<E,R>{
}
