package org.nanotek.repository.jpa;

import org.nanotek.IdBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdBaseRepository<K extends IdBase<? , Long>> extends  JpaRepository<K, Long> {
}
