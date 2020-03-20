package org.nanotek.repository.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.Area;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository<K extends Area<K>> extends  
	LongIdGidNameEntityRepository<K>{
	Optional<Area<?>> findByAreaId(@NotNull Long areaId);
}