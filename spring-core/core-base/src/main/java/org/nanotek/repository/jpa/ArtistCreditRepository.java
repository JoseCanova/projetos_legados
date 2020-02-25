package org.nanotek.repository.jpa;

import java.util.Optional;

import org.nanotek.beans.ArtistCredit;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistCreditRepository extends JpaRepository <ArtistCredit ,Long> {	
	
	/*
	 * public ArtistCredit(@NotNull @Length(min = 1, max = 1000) String
	 * name, @NotNull Long artistCount,
	 * 
	 * @NotNull Long refCount, Set<Recording> recordings) { super(); this.name =
	 * name; this.artistCount = artistCount; this.refCount = refCount;
	 * this.recordings = recordings; }
	 */
	
//	@EntityGraph(value = "fetch.ArtistCredit.recordings")
	@EntityGraph(value="fetch.ArtistCredit.recordings")
	Optional<ArtistCredit>  findArtistCreditRecordingsById(Long id);
}
