package org.nanotek.repository.jpa;

import java.util.List;

import org.nanotek.beans.ArtistName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistNameRepository extends JpaRepository <ArtistName ,Long> {
	
	@Query("from ArtistName a left outer join fetch a.artistCredits where a.artistId = ?1")
	List<ArtistName> findByArtistId(Long artistId);
	
	List<ArtistName> findByNameContainingIgnoreCase(String name);
	
	
	@Query("select new org.nanotek.beans.ArtistName(a.id , a.artistId , a.name , a.sortName , a.gid) "
			+ "from ArtistName a where UPPER(a.name) like %:name% order by a.name")
	List<ArtistName> findByNameEspec(@Param("name")String name);

}
