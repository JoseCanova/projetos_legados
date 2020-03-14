package org.nanotek.repository.jpa;
import java.util.Optional;

import org.nanotek.ImmutableGid;

public interface GidBaseRepository<K extends ImmutableGid<?>> {
   Optional<K> findByGid();
}
