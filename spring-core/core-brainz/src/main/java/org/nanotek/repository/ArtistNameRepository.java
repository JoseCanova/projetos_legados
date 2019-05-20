package org.nanotek.repository;

import java.util.List;

import org.nanotek.LongIdBaseRepository;
import org.nanotek.Nameable;
import org.nanotek.beans.ArtistName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistNameRepository extends JpaRepository<ArtistName, Long> , LongIdBaseRepository<ArtistName> , Nameable<ArtistName>{

	List<ArtistName> findAll(Sort sort);
	Page<ArtistName> findAll(Pageable page);

}
