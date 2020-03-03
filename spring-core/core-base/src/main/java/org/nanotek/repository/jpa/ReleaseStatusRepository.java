package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ReleaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseStatusRepository extends JpaRepository<ReleaseStatus, Long> {
}
