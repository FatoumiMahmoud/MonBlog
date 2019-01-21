package org.fatoumi.exercice.service;

import org.fatoumi.exercice.entity.Comment;
import org.fatoumi.exercice.entity.CommentEntity;
import org.fatoumi.exercice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultCommentService implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Iterable<? extends Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment find(Integer id) {
        Optional<CommentEntity> optionalCommentEntity = commentRepository.findById(id);
        return optionalCommentEntity.isPresent() ? optionalCommentEntity.get() : null;
    }

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save((CommentEntity) comment);
    }

    @Override
    public Comment edit(Comment comment) {
        return commentRepository.save((CommentEntity) comment);
    }

    @Override
    public void delete(Integer id) {
        CommentEntity commentEntityToDelete = (CommentEntity) this.find(id);
        if (commentEntityToDelete != null) {
            commentRepository.delete(commentEntityToDelete);
        }
    }

    @Override
    public Iterable<? extends Comment> findByArticle(Integer articleId) {
        return commentRepository.findAllByArticle(articleId);
    }
}
