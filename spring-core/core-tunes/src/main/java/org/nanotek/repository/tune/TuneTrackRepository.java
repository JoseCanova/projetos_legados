package org.nanotek.repository.tune;

import org.nanotek.beans.musicbrainz.TuneTrack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuneTrackRepository   extends JpaRepository<TuneTrack , Long>{
}
