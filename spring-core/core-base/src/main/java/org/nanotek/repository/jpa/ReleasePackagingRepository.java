package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ReleasePackaging;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleasePackagingRepository extends  LongIdGidNameEntityRepository<ReleasePackaging> , ReleasePackagingBaseRepository<ReleasePackaging,Long>{
}
