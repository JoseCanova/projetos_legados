package org.nanotek.repository.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.BaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseTypeRepository<T extends BaseType<?>> extends JpaRepository<T,Long> {
	Optional<T> findByTypeId(@NotNull Long typeId);
}
