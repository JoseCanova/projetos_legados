package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.CommentBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentBaseRepository<C extends CommentBase> extends JpaRepository<C, Long> {
}
