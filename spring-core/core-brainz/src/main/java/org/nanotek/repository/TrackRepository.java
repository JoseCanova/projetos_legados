package org.nanotek.repository;

import java.util.List;

import org.nanotek.LongIdBaseRepository;
import org.nanotek.Nameable;
import org.nanotek.beans.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> , LongIdBaseRepository<Track> , Nameable<Track>{

	List<Track> findByRecordingId(Long recordingId);
	
}
