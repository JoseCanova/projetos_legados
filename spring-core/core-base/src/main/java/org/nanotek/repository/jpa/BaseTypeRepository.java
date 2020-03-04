package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.BaseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseTypeRepository<T extends BaseType> extends JpaRepository<T,Long> {
}
