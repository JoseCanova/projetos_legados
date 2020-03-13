package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.RecordingAlias;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordingAliasJpaRepository  extends LongIdSortNameEntityRepository<RecordingAlias> {
}
