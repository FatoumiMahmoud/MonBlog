package org.fatoumi.exercice.mock.dao;

import org.fatoumi.exercice.mock.entity.ArticleMock;
import org.fatoumi.exercice.mock.entity.CommentMock;
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

    private List<CommentMock> commentMocks = new ArrayList<>();

    private Integer lastId = 0;

    @PostConstruct
    private void init() {
        articleDao.findAll().stream().forEach(a -> setRandomComments(a));
    }

    @Override
    public List<CommentMock> findAll() {
        return this.commentMocks;
    }

    @Override
    public CommentMock find(Integer id) {
        CommentMock commentMock = null;
        Optional<CommentMock> optionalComment = this.commentMocks.stream()
                .filter(c -> c.getId() == id).findFirst();
        if (optionalComment.isPresent()) {
            commentMock = optionalComment.get();
        }
        return commentMock;
    }

    @Override
    public Iterable<CommentMock> findByArticle(Integer articleId) {
        Iterable<CommentMock> commentMocks = null;
        Optional<ArticleMock> optionalArticleMock = this.articleDao.findAll()
                .stream().filter(a -> articleId.equals(a.getId())).findFirst();
        if (optionalArticleMock.isPresent()) {
            commentMocks = optionalArticleMock.get().getCommentMocks();
        }
        return commentMocks;
    }

    @Override
    public CommentMock create(CommentMock commentMock) {
        commentMock.setId(findLastId() + 1);
        this.commentMocks.add(commentMock);
        return commentMock;
    }

    @Override
    public CommentMock edit(CommentMock commentMock) {
        CommentMock editedCommentMock = this.find(commentMock.getId());
        editedCommentMock.setValue(commentMock.getValue());
        return editedCommentMock;
    }

    @Override
    public void delete(Integer id) {
        ArticleMock articleMock = articleDao.findAll()
                .stream()
                .filter(a -> (a.getCommentMocks().stream().filter(c -> id.equals(c.getId()))).findFirst().isPresent())
                .findFirst()
                .get();

        articleMock.setCommentMocks(articleMock.getCommentMocks().stream().filter(c -> !id.equals(c.getId())).collect(Collectors.toList()));
        this.commentMocks = this.commentMocks.stream().filter(c -> !id.equals(c.getId())).collect(Collectors.toList());
    }

    private void setRandomComments(ArticleMock articleMock) {
        CommentMock c1 = new CommentMock(++lastId, "Commmmmmments " + lastId),
                c2 = new CommentMock(++lastId, "Commmmmmments " + lastId);
        articleMock.getCommentMocks().add(c1);
        articleMock.getCommentMocks().add(c2);
        this.commentMocks.add((CommentMock) c1);
        this.commentMocks.add((CommentMock) c2);
    }

    private Integer findLastId() {
        Integer lastId = 0;
        Optional<CommentMock> optionalComment = this.commentMocks.stream().max(Comparator.comparing(CommentMock::getId));
        if (optionalComment.isPresent()) {
            lastId = optionalComment.get().getId();
        }
        return lastId;
    }
}
