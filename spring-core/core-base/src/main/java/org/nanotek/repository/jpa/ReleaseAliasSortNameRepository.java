package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ReleaseAliasSortName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseAliasSortNameRepository extends JpaRepository<ReleaseAliasSortName, Long> {

}
