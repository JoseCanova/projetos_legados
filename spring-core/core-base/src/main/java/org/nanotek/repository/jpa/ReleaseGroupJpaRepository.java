package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ReleaseGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseGroupJpaRepository extends JpaRepository<ReleaseGroup, Long> {

}
