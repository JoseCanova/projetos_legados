package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.BaseTypeDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseTypeDescriptionRepository extends JpaRepository<BaseTypeDescription, Long> {
}
