package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ReleaseGroup;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseGroupRepository extends LongIdGidNameEntityRepository<ReleaseGroup> , ReleaseGroupBaseRepository<ReleaseGroup , Long> {
}
