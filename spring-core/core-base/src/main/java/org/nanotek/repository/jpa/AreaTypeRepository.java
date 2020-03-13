package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.AreaType;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaTypeRepository extends BaseTypeRepository<AreaType> , NameBaseProjection<AreaType>{
}
