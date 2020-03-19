package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.RecordingAliasType;
import org.nanotek.beans.entity.ReleaseAliasType;
import org.nanotek.repository.jpa.projections.BaseTypeProjection;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordingAliasTypeRepository extends 
IdBaseRepository<RecordingAliasType<?>>,
BaseTypeProjection<ReleaseAliasType>,
NameBaseProjection<ReleaseAliasType>{
}
