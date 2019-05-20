package org.nanotek.repository.tune;

import org.nanotek.beans.musicbrainz.TuneRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuneRecordRepository  extends JpaRepository<TuneRecord , Long>{

}
