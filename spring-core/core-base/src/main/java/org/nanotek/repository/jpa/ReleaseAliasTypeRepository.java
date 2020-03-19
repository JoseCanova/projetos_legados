package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ReleaseAliasType;
import org.nanotek.repository.jpa.projections.BaseTypeProjection;
import org.nanotek.repository.jpa.projections.NameBaseProjection;

public interface ReleaseAliasTypeRepository extends 
IdBaseRepository<ReleaseAliasType> , 
BaseTypeProjection<ReleaseAliasType> , 
NameBaseProjection<ReleaseAliasType>{

}
