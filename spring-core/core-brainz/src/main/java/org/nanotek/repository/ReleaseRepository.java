package org.nanotek.repository;

import java.util.List;

import org.nanotek.LongIdBaseRepository;
import org.nanotek.Nameable;
import org.nanotek.beans.Release;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseRepository extends JpaRepository<Release, Long> , LongIdBaseRepository<Release> , Nameable<Release> {

	public List<Release> findByArtistCredit(Long artistCreditId);
	
}
