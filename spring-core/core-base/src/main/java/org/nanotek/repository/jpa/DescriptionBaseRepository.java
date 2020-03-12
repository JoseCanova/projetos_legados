package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.DescriptionBase;
import org.nanotek.repository.jpa.projections.DescriptionBaseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionBaseRepository<K extends DescriptionBase> extends JpaRepository<K, Long> , DescriptionBaseProjection<String , K> {
}
