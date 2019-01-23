package org.fatoumi.exercice.service;

import org.fatoumi.exercice.entity.Article;
import org.fatoumi.exercice.entity.Comment;

public interface ArticleService {

    /**
     * @return list off all articles
     */
    Iterable<Article> findAll();

    /**
     * @param id article id
     * @return the article with the id
     */
    Article find(Integer id);

    /**
     * @param Article the Article without id
     * @return the created Article
     */
    Article create(Article Article);

    /**
     * @param Article
     * @return the edited Article
     */
    Article edit(Article Article);

    /**
     * @param id article id to be deleted
     */
    void delete(Integer id);

    /**
     * @param id      article id
     * @param comment the commentMock to be added to the article
     * @return the article after modification
     */
    Article addComment(Integer id, Comment comment);
}
