package org.fatoumi.exercice.mock.dao;

import org.fatoumi.exercice.mock.entity.ArticleMock;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultArticleDao implements ArticleDao {


    private List<ArticleMock> articleMocks = new ArrayList<>();

    @PostConstruct
    public void init() {
        articleMocks.add(new ArticleMock(1, "First ArticleMock", "First article content"));
        articleMocks.add(new ArticleMock(2, "Second ArticleMock", "Second article content"));
        articleMocks.add(new ArticleMock(3, "Third ArticleMock", "Third article content"));
        articleMocks.add(new ArticleMock(4, "Fourth ArticleMock", "Fourth article content"));
        articleMocks.add(new ArticleMock(5, "Fifth ArticleMock", "Fifth article content"));
    }

    @Override
    public List<ArticleMock> findAll() {
        return articleMocks;
    }

    @Override
    public ArticleMock find(Integer id) {
        ArticleMock articleMock = null;
        Optional<ArticleMock> optional = articleMocks.stream().filter(a -> a.getId() == id).findFirst();
        if (optional.isPresent()) {
            articleMock = optional.get();
        }
        return articleMock;
    }

    @Override
    public ArticleMock create(ArticleMock articleMock) {
        articleMock.setId(findLastId() + 1);
        articleMocks.add(articleMock);
        return articleMock;
    }

    @Override
    public ArticleMock edit(ArticleMock articleMock) {
        ArticleMock editedArticleMock = find(articleMock.getId());
        if (editedArticleMock == null) {
            editedArticleMock = this.create(articleMock);
        } else {
            editedArticleMock.setTitle(articleMock.getTitle());
            editedArticleMock.setContent(articleMock.getContent());
        }
        return editedArticleMock;
    }

    @Override
    public void delete(Integer id) {
        articleMocks = articleMocks.stream().filter(a -> a.getId() != id).collect(Collectors.toList());
    }

    private Integer findLastId() {
        Optional<ArticleMock> optional = articleMocks.stream().max(Comparator.comparing(ArticleMock::getId));
        return optional.isPresent() ? optional.get().getId() : 0;
    }
}
