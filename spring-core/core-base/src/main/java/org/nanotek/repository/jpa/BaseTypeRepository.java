package org.nanotek.repository.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.AreaType;
import org.nanotek.beans.entity.BaseType;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseTypeRepository<T extends BaseType> extends LongIdNameEntityRepository<T> ,  NameBaseProjection<T> {
	Optional<T> findByTypeId(@NotNull Long typeId);
}
