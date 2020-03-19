package org.nanotek.repository.jpa;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseDescriptionBaseRepository<ID extends Serializable> extends JpaRepository<ID,Long> {
	Optional<?> findByDescription(ID id);
}
