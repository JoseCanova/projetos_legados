package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.Release;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends LongIdGidNameEntityRepository<Release> , ReleaseBaseRepository<Release,Long>{
}
