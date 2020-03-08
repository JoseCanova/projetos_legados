package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ReleaseAliasBeginDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseAliasBeginDateRepository extends JpaRepository<ReleaseAliasBeginDate, Long> {
}