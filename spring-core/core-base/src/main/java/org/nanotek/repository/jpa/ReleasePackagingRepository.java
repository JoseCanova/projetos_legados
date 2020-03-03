package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ReleasePackaging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleasePackagingRepository extends JpaRepository<ReleasePackaging,Long>{
}
