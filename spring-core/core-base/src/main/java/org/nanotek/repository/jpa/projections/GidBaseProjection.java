package org.nanotek.repository.jpa.projections;
import java.util.Optional;

import org.nanotek.IdBase;
import org.nanotek.entities.MutableGidEntity;

public interface GidBaseProjection<K extends MutableGidEntity<?>> {
   Optional<K> findByGid();
}
