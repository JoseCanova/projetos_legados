package org.nanotek.service;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.Area;
import org.nanotek.beans.entity.BrainzBaseEntity;
import org.nanotek.repository.jpa.BrainzBaseRepository;
import org.nanotek.repository.jpa.projections.NameBaseProjection;

public interface BaseService<K extends BrainzBaseEntity<K>> extends  
BrainzBaseRepository<K>,
NameBaseProjection<K, String>{
Optional<Area<?>> findByAreaId(@NotNull Long areaId);
}
