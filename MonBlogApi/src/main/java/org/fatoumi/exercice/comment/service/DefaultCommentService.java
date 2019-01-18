package org.fatoumi.exercice.comment.service;

import org.fatoumi.exercice.comment.Comment;
import org.fatoumi.exercice.comment.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCommentService implements CommentService {

    @Autowired
    private CommentDao commentDao;

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
    }
}
