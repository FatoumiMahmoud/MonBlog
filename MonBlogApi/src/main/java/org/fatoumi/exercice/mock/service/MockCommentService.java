package org.fatoumi.exercice.mock.service;

import org.fatoumi.exercice.mock.dao.CommentDao;
import org.fatoumi.exercice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MockCommentService implements CommentService {

    @Autowired
    private CommentDao commentDao;
/*
    @Override
    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    @Override
    public Comment find(Integer id) {
        return commentDao.find(id);
    }

    @Override
    public Comment create(Comment comment) {
        return commentDao.create(comment);
    }

    @Override
    public Comment edit(Comment comment) {
        return commentDao.edit(comment);
    }

    @Override
    public void delete(Integer id) {
        commentDao.delete(id);
    }*/
}
