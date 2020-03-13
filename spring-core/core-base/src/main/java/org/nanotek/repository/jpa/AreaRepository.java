package org.nanotek.repository.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.Area;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends  LongIdGidNameEntityRepository<Area>{
	Optional<Area> findByAreaId(@NotNull Long areaId);
}