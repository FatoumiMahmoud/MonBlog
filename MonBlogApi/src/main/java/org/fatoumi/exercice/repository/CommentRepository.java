package org.fatoumi.exercice.repository;

import org.fatoumi.exercice.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

    @Query("SELECT C FROM ArticleEntity A LEFT JOIN A.comments C WHERE A.id = ?1")
    List<CommentEntity> findAllByArticle(Integer articleId);
}
