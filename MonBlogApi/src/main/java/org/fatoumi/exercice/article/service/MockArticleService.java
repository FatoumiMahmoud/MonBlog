package org.fatoumi.exercice.article.service;

import org.fatoumi.exercice.article.Article;
import org.fatoumi.exercice.article.dao.ArticleDao;
import org.fatoumi.exercice.comment.Comment;
import org.fatoumi.exercice.comment.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class MockArticleService implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CommentDao commentDao;

    @Override
    public Iterable<Article> findAll2() {
        return null;
    }

    @Override
    public List<Article> findAll() {
        return articleDao.findAll();
    }

    @Override
    public Article find(Integer id) {
        return articleDao.find(id);
    }

    @Override
    public Article create(Article article) {
        return articleDao.create(article);
    }

    @Override
    public Article edit(Article article) {
        return articleDao.edit(article);
    }

    @Override
    public void delete(Integer id) {
        articleDao.delete(id);
    }

    @Override
    public Article addComment(Integer id, Comment comment) {
        Comment serializedComment = commentDao.create(comment);
        Article article = this.find(id);
        article.getComments().add(serializedComment);
        return article;
    }
}


