package org.nanotek.repository.jpa;

import java.util.List;

import org.nanotek.beans.entity.Artist;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository <Artist ,Long> , NameBaseProjection<Artist>{
	
	@Query("from Artist a left outer join fetch a.artistCredits where a.id = ?1")
	List<Artist> findByArtistId(Long artistId);
	
	@Query("select new org.nanotek.beans.Artist(a.id , a.name , a.sortName , a.gid) "
			+ "from Artist a where UPPER(a.name) like %:name% order by a.name")
	List<Artist> findByNameEspec(@Param("name")String name);

}
