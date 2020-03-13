package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.Release;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository<K extends Release> extends LongIdGidNameEntityRepository<K> , ReleaseBaseRepository<Release,Long>{
}
