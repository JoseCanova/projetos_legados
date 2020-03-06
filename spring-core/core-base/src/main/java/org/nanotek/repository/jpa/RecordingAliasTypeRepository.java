package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.RecordingAliasType;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordingAliasTypeRepository extends BaseTypeRepository<RecordingAliasType>, NameBaseProjection<RecordingAliasType>{

}
