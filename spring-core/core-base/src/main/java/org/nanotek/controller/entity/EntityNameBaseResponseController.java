package org.nanotek.controller.entity;

import org.nanotek.EntityNameBase;
import org.nanotek.repository.jpa.EntityNameBaseRepository;

public interface EntityNameBaseResponseController< E extends EntityNameBase<Long,?> , R extends EntityNameBaseRepository<E, Long>> extends EntityResponseController<E,R>{
}
