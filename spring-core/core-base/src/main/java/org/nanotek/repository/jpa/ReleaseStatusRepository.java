package org.nanotek.repository.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.ReleaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseStatusRepository extends JpaRepository<ReleaseStatus, Long> {
	Optional<ReleaseStatus> findByReleaseStatusId(@NotNull Long releaseStatusId);
}