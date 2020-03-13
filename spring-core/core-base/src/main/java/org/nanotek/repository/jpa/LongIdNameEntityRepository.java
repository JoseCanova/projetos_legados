package org.nanotek.repository.jpa;

import org.nanotek.LongIdEntityNameBase;
import org.springframework.stereotype.Repository;

@Repository
public interface LongIdNameEntityRepository<K extends LongIdEntityNameBase> extends LongIdEntityNameBaseRepository<K> {
}