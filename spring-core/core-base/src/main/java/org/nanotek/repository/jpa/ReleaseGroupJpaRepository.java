package org.nanotek.repository.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.ReleaseGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseGroupJpaRepository extends JpaRepository<ReleaseGroup, Long> {
	Optional<ReleaseGroup> findByReleaseGroupId(@NotNull Long releaseGroupId);
}
