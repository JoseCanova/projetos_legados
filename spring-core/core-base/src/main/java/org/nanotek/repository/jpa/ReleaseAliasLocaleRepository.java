package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ReleaseAliasLocale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseAliasLocaleRepository extends JpaRepository<ReleaseAliasLocale, Long> {
}
