package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ReleasePackaging;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleasePackagingRepository<K extends ReleasePackaging<K>> 
extends  IdBaseRepository<ReleasePackagingRepository<K> , K> ,
ReleasePackagingBaseRepository<K,Long>{
}
