package org.nanotek.repository;

import org.nanotek.beans.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends JpaRepository <Release ,Long>{
}
