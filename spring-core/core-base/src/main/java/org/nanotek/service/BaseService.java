package org.nanotek.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseService<O> extends JpaRepository<O, Long> {
}
