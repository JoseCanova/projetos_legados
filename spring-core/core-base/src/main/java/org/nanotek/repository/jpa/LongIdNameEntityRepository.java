package org.nanotek.repository.jpa;

import org.nanotek.LongIdEntityBase;
import org.springframework.stereotype.Repository;

@Repository
public interface LongIdNameEntityRepository<K extends LongIdEntityBase> extends LongIdEntityNameBaseRepository<K> {
}