package org.nanotek.repository.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.ArtistCredit;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistCreditRepository extends LongIdNameEntityRepository<ArtistCredit> {	
	
	@EntityGraph(value="fetch.ArtistCredit.recordings")
	Optional<ArtistCredit>  findArtistCreditRecordingsById(@NotNull  Long id);
	
	Optional<ArtistCredit> findByArtistCreditId(@NotNull Long artistCreditId);

}
