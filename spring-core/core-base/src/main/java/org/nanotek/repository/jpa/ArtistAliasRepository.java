package org.nanotek.repository.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.ArtistAlias;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistAliasRepository extends LongIdNameEntityRepository<ArtistAlias>{
	Optional<ArtistAlias> findByAliasId(@NotNull Long aliasId);
}
