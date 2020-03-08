package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ReleaseAlias;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseAliasJpaRepository extends JpaRepository <ReleaseAlias ,Long> , NameBaseProjection<ReleaseAlias>{
}
