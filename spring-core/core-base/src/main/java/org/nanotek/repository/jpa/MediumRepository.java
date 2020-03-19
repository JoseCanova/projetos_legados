package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.Medium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediumRepository extends JpaRepository<Medium,Long>{
}
