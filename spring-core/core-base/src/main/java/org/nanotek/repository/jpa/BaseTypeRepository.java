package org.nanotek.repository.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.BaseType;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseTypeRepository<T extends BaseType> extends JpaRepository<T,Long>, NameBaseProjection<T> {
	Optional<T> findByTypeId(@NotNull Long typeId);
}
