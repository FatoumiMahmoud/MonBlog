package org.fatoumi.exercice.mock.dao;

import org.fatoumi.exercice.mock.entity.CommentMock;

import java.util.List;

public interface CommentDao {

    /**
     * @return list off all commentMocks
     */
    List<CommentMock> findAll();

    /**
     * @param id article id
     * @return the comment with the id
     */
    CommentMock find(Integer id);

    /**
     * @param articleId
     * @return the list of all commentMocks for given article id
     */
    CommentMock findByArticle(Integer articleId);

    /**
     * @param commentMock the commentMock without id
     * @return the created commentMock
     */
    CommentMock create(CommentMock commentMock);

    /**
     * @param commentMock
     * @return the edited commentMock
     */
    CommentMock edit(CommentMock commentMock);

    /**
     * @param id comment id to be deleted
     */
    void delete(Integer id);
}
