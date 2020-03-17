package org.nanotek.repository.jpa;


import org.nanotek.beans.entity.LongIdGidName;

public interface LongIdGidNameEntityRepository<K extends LongIdGidName> extends LongIdNameEntityRepository<K> , GidBaseRepository<K> {
}
