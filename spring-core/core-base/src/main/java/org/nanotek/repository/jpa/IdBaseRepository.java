package org.nanotek.repository.jpa;

import org.nanotek.Base;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdBaseRepository<K extends IdBaseRepository<K,B> , B extends Base<B>> extends  JpaRepository<B, Long> {
}
