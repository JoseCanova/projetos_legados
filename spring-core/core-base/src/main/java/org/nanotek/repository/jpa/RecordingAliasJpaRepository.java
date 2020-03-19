package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.RecordingAlias;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordingAliasJpaRepository  extends 
LongIdSortNameEntityRepository<RecordingAlias> {
}
