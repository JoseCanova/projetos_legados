package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.Area;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository <Area ,Long> , NameBaseProjection<Area>{
}
