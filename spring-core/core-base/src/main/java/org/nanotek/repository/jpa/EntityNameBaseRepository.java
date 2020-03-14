package org.nanotek.repository.jpa;

import java.io.Serializable;

import org.nanotek.MutableNameBase;

public interface EntityNameBaseRepository<E extends MutableNameBase<ID, ? > , ID extends Serializable> extends EntityBaseRepository<E, ID> {
}
