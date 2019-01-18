package org.fatoumi.exercice.article.service;

import org.fatoumi.exercice.article.Article;
import org.fatoumi.exercice.comment.Comment;

import java.util.List;

public interface ArticleService {

    Iterable<Article> findAll2();

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

    /**
     *
     * @param id article id
     * @param comment the comment to be added to the article
     * @return the article after modification
     */
    Article addComment(Integer id, Comment comment);
}
