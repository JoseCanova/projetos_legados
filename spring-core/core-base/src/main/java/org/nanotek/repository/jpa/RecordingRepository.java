package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.Recording;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordingRepository extends LongIdGidNameEntityRepository<Recording> , RecordingBaseRepository<Recording,Long>{
}
