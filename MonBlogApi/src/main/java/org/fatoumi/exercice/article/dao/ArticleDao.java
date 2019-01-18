package org.fatoumi.exercice.article.dao;

import org.fatoumi.exercice.article.Article;

import java.util.List;

public interface ArticleDao {
    /**
     *
     * @return list off all articles
     */
    List<Article> findAll();

    /**
     *
     * @param id article id
     * @return the article with the id
     */
    Article find(Integer id);

    /**
     *
     * @param article the article without id
     * @return the created article
     */
    Article create(Article article);
    /**
     *
     * @param article
     * @return the edited article
     */
    Article edit(Article article);

    /**
     *
     * @param id article id to be deleted
     */
    void delete(Integer id);

}
