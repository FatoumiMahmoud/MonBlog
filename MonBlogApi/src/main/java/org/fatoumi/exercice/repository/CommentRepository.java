package org.fatoumi.exercice.repository;

import org.fatoumi.exercice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query("SELECT C FROM Article A LEFT JOIN A.comments C WHERE A.id = ?1")
    List<Comment> findAllByArticle(Integer articleId);
}
