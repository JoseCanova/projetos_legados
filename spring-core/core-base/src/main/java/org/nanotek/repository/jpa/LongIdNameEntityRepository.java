package org.nanotek.repository.jpa;

import org.nanotek.LongIdEntityBase;
import org.nanotek.beans.entity.LongIdName;
import org.springframework.stereotype.Repository;

@Repository
public interface LongIdNameEntityRepository<K extends LongIdName<K>> extends LongIdEntityNameBaseRepository<K> {
}