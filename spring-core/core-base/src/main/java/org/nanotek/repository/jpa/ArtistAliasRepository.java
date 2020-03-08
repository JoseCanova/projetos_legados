package org.nanotek.repository.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.ArtistAlias;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistAliasRepository extends JpaRepository<ArtistAlias,Long> , NameBaseProjection<ArtistAlias>{
	Optional<ArtistAlias> findByAliasId(@NotNull Long aliasId);
}
