package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends JpaRepository <Release ,Long>{
}
