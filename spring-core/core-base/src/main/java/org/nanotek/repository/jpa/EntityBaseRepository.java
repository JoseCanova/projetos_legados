package org.nanotek.repository.jpa;

import java.io.Serializable;

import org.nanotek.EntityBase;

public interface EntityBaseRepository<E extends EntityBase<ID> , ID extends Serializable> extends IdBaseRepository<E, ID>{
}
