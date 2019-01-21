package org.fatoumi.exercice.repository;

import org.fatoumi.exercice.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
}
