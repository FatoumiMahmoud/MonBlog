package org.fatoumi.exercice.mock.dao;

import org.fatoumi.exercice.entity.Comment;
import org.fatoumi.exercice.mock.entity.CommentMock;

import java.util.List;

public interface CommentDao {

    /**
     * @return list off all Comments
     */
    List<CommentMock> findAll();

    /**
     * @param id article id
     * @return the comment with the id
     */
    Comment find(Integer id);

    /**
     * @param articleId
     * @return the list of all Comments for given article id
     */
    Iterable<CommentMock> findByArticle(Integer articleId);

    /**
     * @param Comment the Comment without id
     * @return the created Comment
     */
    CommentMock create(CommentMock Comment);

    /**
     * @param Comment
     * @return the edited Comment
     */
    CommentMock edit(CommentMock Comment);

    /**
     * @param id comment id to be deleted
     */
    void delete(Integer id);
}
