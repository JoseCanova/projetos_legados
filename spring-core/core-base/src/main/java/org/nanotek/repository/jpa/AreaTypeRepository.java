package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.AreaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaTypeRepository extends JpaRepository<AreaType, Long> {
}
