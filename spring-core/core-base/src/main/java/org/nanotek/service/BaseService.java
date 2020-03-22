package org.nanotek.service;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.BaseEntity;
import org.nanotek.beans.entity.Area;
import org.nanotek.beans.entity.SequenceLongBase;
import org.nanotek.repository.jpa.AreaRepository;
import org.nanotek.repository.jpa.SequenceLongBaseRepository;
import org.nanotek.repository.jpa.projections.NameBaseProjection;

public interface BaseService<K extends SequenceLongBase<K,Long>> extends  
SequenceLongBaseRepository<K>,
NameBaseProjection<K, String>{
Optional<Area<?>> findByAreaId(@NotNull Long areaId);
}
