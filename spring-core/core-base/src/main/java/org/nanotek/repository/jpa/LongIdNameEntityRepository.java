package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.LongIdName;
import org.nanotek.entities.immutables.LongIdEntityBase;
import org.springframework.stereotype.Repository;

@Repository
public interface LongIdNameEntityRepository<K extends LongIdName<K>> extends LongIdEntityNameBaseRepository<K> {
}