package org.nanotek.repository.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.ArtistCredit;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistCreditRepository extends IdBaseRepository<ArtistCredit<?>> , NameBaseProjection<ArtistCredit<?>> {	
	
	@EntityGraph(value="fetch.ArtistCredit.recordings")
	Optional<ArtistCredit<?>>  findArtistCreditRecordingsById(@NotNull  Long id);
	
	Optional<ArtistCredit<?>> findByArtistCreditId(@NotNull Long artistCreditId);

}
