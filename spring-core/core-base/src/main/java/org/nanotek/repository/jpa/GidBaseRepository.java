package org.nanotek.repository.jpa;
import java.util.Optional;

import org.nanotek.GidBase;

public interface GidBaseRepository<K extends GidBase<?>> {
   Optional<K> findByGid();
}
