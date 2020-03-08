package org.nanotek.repository.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.ReleasePackaging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleasePackagingRepository extends JpaRepository<ReleasePackaging,Long>{
	Optional<ReleasePackaging> findByReleasePackagingId(@NotNull Long releasePackagingId);
}
