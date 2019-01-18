package org.fatoumi.exercice.mock.dao;

import org.fatoumi.exercice.mock.entity.ArticleMock;

import java.util.List;

public interface ArticleDao {
    /**
     * @return list off all articles
     */
    List<ArticleMock> findAll();

    /**
     * @param id article id
     * @return the article with the id
     */
    ArticleMock find(Integer id);

    /**
     * @param articleMock the articleMock without id
     * @return the created articleMock
     */
    ArticleMock create(ArticleMock articleMock);

    /**
     * @param articleMock
     * @return the edited articleMock
     */
    ArticleMock edit(ArticleMock articleMock);

    /**
     * @param id article id to be deleted
     */
    void delete(Integer id);

}
