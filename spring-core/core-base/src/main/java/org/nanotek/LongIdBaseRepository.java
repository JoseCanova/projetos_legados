package org.nanotek;

import org.springframework.data.repository.CrudRepository;

public interface LongIdBaseRepository <T extends Identifiable<Long>> extends CrudRepository<T, Long> {
}
