package org.nanotek.repository.tune;

import org.nanotek.beans.musicbrainz.TuneArtist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuneArtistRepository extends JpaRepository<TuneArtist , Long> {
}
