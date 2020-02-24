package org.nanotek.repository.jpa;

import org.nanotek.beans.RecordingLength;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordingLenghtRepository extends JpaRepository<RecordingLength, Long> {
}
