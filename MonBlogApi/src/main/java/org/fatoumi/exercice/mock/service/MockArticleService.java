package org.fatoumi.exercice.mock.service;

import org.fatoumi.exercice.entity.Article;
import org.fatoumi.exercice.entity.Comment;
import org.fatoumi.exercice.mock.dao.ArticleDao;
import org.fatoumi.exercice.mock.dao.CommentDao;
import org.fatoumi.exercice.mock.entity.ArticleMock;
import org.fatoumi.exercice.mock.entity.CommentMock;
import org.fatoumi.exercice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MockArticleService implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CommentDao commentDao;

    @Override
    public Iterable<ArticleMock> findAll() {
        return articleDao.findAll();
    }

    @Override
    public ArticleMock find(Integer id) {
        return articleDao.find(id);
    }

    @Override
    public ArticleMock create(Article article) {
        return articleDao.create((ArticleMock) article);
    }

    @Override
    public ArticleMock edit(Article article) {
        return articleDao.edit((ArticleMock) article);
    }

    @Override
    public void delete(Integer id) {
        articleDao.delete(id);
    }


    @Override
    public Article addComment(Integer id, Comment comment) {
        CommentMock serializedComment = commentDao.create((CommentMock) comment);
        ArticleMock article = this.find(id);
        article.getCommentMocks().add(serializedComment);
        return article;
    }
}