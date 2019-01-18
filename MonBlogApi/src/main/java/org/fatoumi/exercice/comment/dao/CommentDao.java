package org.fatoumi.exercice.comment.dao;

import org.fatoumi.exercice.comment.Comment;

import java.util.List;

public interface CommentDao {

    /**
     * @return list off all comments
     */
    List<Comment> findAll();

    /**
     * @param id article id
     * @return the comment with the id
     */
    Comment find(Integer id);

    /**
     * @param articleId
     * @return the list of all comments for given article id
     */
    Comment findByArticle(Integer articleId);

    /**
     * @param comment the comment without id
     * @return the created comment
     */
    Comment create(Comment comment);

    /**
     * @param comment
     * @return the edited comment
     */
    Comment edit(Comment comment);

    /**
     * @param id comment id to be deleted
     */
    void delete(Integer id);
}
