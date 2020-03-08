package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.InstrumentComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentCommentRepository extends JpaRepository<InstrumentComment, Long> {
}
