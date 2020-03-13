package org.nanotek.repository.jpa;


import org.nanotek.beans.entity.LongIdGidNameEntity;

public interface LongIdGidNameEntityRepository<K extends LongIdGidNameEntity> extends LongIdNameEntityRepository<K> , GidBaseRepository<K> {
}
