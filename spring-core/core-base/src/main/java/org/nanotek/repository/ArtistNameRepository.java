package org.nanotek.repository;

import java.util.List;

import org.nanotek.beans.ArtistName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistNameRepository extends JpaRepository <ArtistName ,Long> {
	
	
	@Query("select a from ArtistName a inner join fetch a.artistCredits where a.artistId = ?1")
	List<ArtistName> findByArtistId(Long artistId);

}
