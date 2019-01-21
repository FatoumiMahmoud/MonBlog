package org.fatoumi.exercice.mock.service;

import org.fatoumi.exercice.entity.Comment;
import org.fatoumi.exercice.mock.dao.CommentDao;
import org.fatoumi.exercice.mock.entity.CommentMock;
import org.fatoumi.exercice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MockCommentService implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Iterable<? extends Comment> findAll() {
        return commentDao.findAll();
    }

    @Override
    public Comment find(Integer id) {
        return commentDao.find(id);
    }

    @Override
    public Comment create(Comment comment) {
        return commentDao.create((CommentMock) comment);
    }

    @Override
    public Comment edit(Comment comment) {
        return commentDao.edit((CommentMock) comment);
    }

    @Override
    public void delete(Integer id) {
        commentDao.delete(id);
    }

    @Override
    public Iterable<? extends Comment> findByArticle(Integer articleId) {
        return commentDao.findByArticle(articleId);
    }


}
