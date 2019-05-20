package org.nanotek.repository.tune;

import org.nanotek.beans.musicbrainz.TuneRelease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuneReleaseRepository  extends JpaRepository<TuneRelease , Long> {
}
