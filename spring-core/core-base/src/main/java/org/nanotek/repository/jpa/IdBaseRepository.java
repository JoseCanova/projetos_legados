package org.nanotek.repository.jpa;

import java.io.Serializable;

import org.nanotek.IdBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdBaseRepository<K extends IdBase<K , ID> , ID extends Serializable > extends  JpaRepository<K, ID> {
}
