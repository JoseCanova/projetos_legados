package org.nanotek.repository.jpa;

import java.util.Optional;

import org.nanotek.beans.ArtistCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistCreditRepository extends JpaRepository <ArtistCredit ,Long> {

	@Query("from ArtistCredit ac left outer join fetch ac.artists where ac.artistCreditId = ?1")
	Optional<ArtistCredit> findByArtistCreditId(Long id);
	
}
