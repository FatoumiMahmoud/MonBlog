package org.fatoumi.exercice.service;

import org.fatoumi.exercice.entity.Comment;
import org.fatoumi.exercice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultCommentService implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment find(Integer id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        return optionalComment.isPresent() ? optionalComment.get() : null;
    }

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment edit(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Integer id) {
        Comment commentEntityToDelete = this.find(id);
        if (commentEntityToDelete != null) {
            commentRepository.delete(commentEntityToDelete);
        }
    }

    @Override
    public Iterable<Comment> findByArticle(Integer articleId) {
        return commentRepository.findAllByArticle(articleId);
    }
}
