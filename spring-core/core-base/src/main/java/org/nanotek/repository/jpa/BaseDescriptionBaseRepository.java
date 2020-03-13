package org.nanotek.repository.jpa;

import java.io.Serializable;

import org.nanotek.BaseDescriptionBase;

public interface BaseDescriptionBaseRepository<O extends BaseDescriptionBase<ID , ?> , ID extends Serializable> extends EntityBaseRepository<O, ID>{
}
