package org.nanotek.repository;

import java.util.Optional;

import org.nanotek.beans.ArtistCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistCreditRepository extends JpaRepository <ArtistCredit ,Long> {

	Optional<ArtistCredit> findByArtistCreditId(Long id);
}
