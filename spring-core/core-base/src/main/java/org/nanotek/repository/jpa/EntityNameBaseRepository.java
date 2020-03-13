package org.nanotek.repository.jpa;

import java.io.Serializable;

import org.nanotek.EntityNameBase;

public interface EntityNameBaseRepository<E extends EntityNameBase<ID, ? > , ID extends Serializable> extends EntityBaseRepository<E, ID> {
}
