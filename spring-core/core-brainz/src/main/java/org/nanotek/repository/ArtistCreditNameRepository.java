package org.nanotek.repository;

import java.util.List;

import org.nanotek.beans.ArtistCreditName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistCreditNameRepository extends JpaRepository<ArtistCreditName , Long>{
	
	List<ArtistCreditName> findByArtist(Long artist);
	List<ArtistCreditName> findByArtistCredit(Long artistCredit);
	
}
