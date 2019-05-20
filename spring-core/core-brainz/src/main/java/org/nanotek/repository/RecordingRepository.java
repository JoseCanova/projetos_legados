package org.nanotek.repository;

import java.util.List;

import org.nanotek.LongIdBaseRepository;
import org.nanotek.Nameable;
import org.nanotek.beans.Recording;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordingRepository extends JpaRepository<Recording, Long> , LongIdBaseRepository<Recording> , Nameable<Recording>{
	 List<Recording> findByArtistCredit(Long artistCreditId);
}
