package org.nanotek.repository;

import org.nanotek.LongIdBaseRepository;
import org.nanotek.Nameable;
import org.nanotek.beans.ArtistCredit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistCreditRepository extends JpaRepository<ArtistCredit, Long> , LongIdBaseRepository<ArtistCredit> , Nameable<ArtistCredit> {

	ArtistCredit findByArtistCreditId(Long artistCreditId);
	
}
