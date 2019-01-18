package org.fatoumi.exercice.comment.dao;

import org.fatoumi.exercice.article.Article;
import org.fatoumi.exercice.article.dao.ArticleDao;
import org.fatoumi.exercice.comment.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultCommentDao implements CommentDao {

    @Autowired
    private ArticleDao articleDao;

    private List<Comment> comments = new ArrayList<>();

    private Integer lastId = 0;

    @PostConstruct
    private void init() {
        articleDao.findAll().stream().forEach(a -> setRandomComments(a));
    }

    @Override
    public List<Comment> findAll() {
        return this.comments;
    }

    @Override
    public Comment find(Integer id) {
        Comment comment = null;
        Optional<Comment> optionalComment = this.comments.stream()
                .filter(c -> c.getId() == id).findFirst();
        if (optionalComment.isPresent()) {
            comment = optionalComment.get();
        }
        return comment;
    }

    @Override
    public Comment findByArticle(Integer articleId) {
        return null;
    }

    @Override
    public Comment create(Comment comment) {
        comment.setId(findLastId() + 1);
        this.comments.add(comment);
        return comment;
    }

    @Override
    public Comment edit(Comment comment) {
        Comment editedComment = this.find(comment.getId());
        editedComment.setValue(comment.getValue());
        return editedComment;
    }

    @Override
    public void delete(Integer id) {
        articleDao.findAll().stream()
                .forEach(a -> a.setComments(a.getComments().stream()
                        .filter(c -> c.getId() != id)
                        .collect(Collectors.toList())));

        this.comments = this.comments.stream().filter(c -> c.getId() == id).collect(Collectors.toList());
    }

    private void setRandomComments(Article article) {
        article.getComments().add(new Comment(++lastId, "Commmmmmments " + lastId));
        article.getComments().add(new Comment(++lastId, "Commmmmmments " + lastId));
        this.comments.addAll(article.getComments());
    }

    private Integer findLastId() {
        Integer lastId = 0;
        Optional<Comment> optionalComment = this.comments.stream().max(Comparator.comparing(Comment::getId));
        if (optionalComment.isPresent()) {
            lastId = optionalComment.get().getId();
        }
        return lastId;
    }
}
