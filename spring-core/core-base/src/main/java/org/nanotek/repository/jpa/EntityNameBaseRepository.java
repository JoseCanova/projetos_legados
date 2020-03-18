package org.nanotek.repository.jpa;

import java.io.Serializable;

import org.nanotek.IdNameBase;
import org.nanotek.entities.MutableNameBase;

public interface EntityNameBaseRepository<E extends IdNameBase<ID, ? > , ID extends Serializable> extends EntityBaseRepository<E, ID> {
}
