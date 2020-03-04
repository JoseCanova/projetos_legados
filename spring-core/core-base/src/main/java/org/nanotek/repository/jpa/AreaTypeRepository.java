package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.AreaType;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaTypeRepository extends JpaRepository<AreaType, Long> , NameBaseProjection<AreaType>{
}
