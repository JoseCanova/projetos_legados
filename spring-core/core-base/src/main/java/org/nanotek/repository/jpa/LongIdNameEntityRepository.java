package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.LongIdNameEntity;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LongIdNameEntityRepository<K extends LongIdNameEntity> extends JpaRepository<K, Long> , NameBaseProjection<K>{
}