package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ReleaseAlias;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseAliasJpaRepository extends LongIdNameEntityRepository<ReleaseAlias> , ReleaseAliasBaseRepository<ReleaseAlias,Long>{
}
