package org.nanotek.repository.jpa;

import java.io.Serializable;

import org.nanotek.IdBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdBaseRepository<E extends IdBase<ID> , ID extends Serializable > extends  JpaRepository<E, ID> {
}
