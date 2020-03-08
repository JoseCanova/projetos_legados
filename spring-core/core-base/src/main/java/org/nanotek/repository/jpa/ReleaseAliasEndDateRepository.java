package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ReleaseAliasEndDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseAliasEndDateRepository extends JpaRepository<ReleaseAliasEndDate, Long> {
}
