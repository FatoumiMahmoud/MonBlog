package org.fatoumi.exercice.article.service;

import org.fatoumi.exercice.article.Article;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DefaultArticleService implements ArticleService {

    private List<Article> articles = new ArrayList<>();

    @PostConstruct
    public void init() {
        articles.add(new Article(1, "First Article", "First article content"));
        articles.add(new Article(2, "Second Article", "Second article content"));
        articles.add(new Article(3, "Third Article", "Third article content"));
        articles.add(new Article(4, "Fourth Article", "Fourth article content"));
        articles.add(new Article(5, "Fifth Article", "Fifth article content"));
    }

    @Override
    public List<Article> findAll() {
        return articles;
    }

    @Override
    public Article find(Integer id) {
        Article article = null;
        Optional<Article> optional = articles.stream().filter(a -> a.getId() == id).findFirst();
        if (optional.isPresent()) {
            article = optional.get();
        }
        return article;
    }

    @Override
    public Article create(Article article) {
        article.setId(findLastId() + 1);
        articles.add(article);
        return article;
    }

    @Override
    public Article edit(Article article) {
        Article editedArticle = find(article.getId());
        if (editedArticle == null) {
            editedArticle = this.create(article);
        } else {
            editedArticle.setTitle(article.getTitle());
            editedArticle.setContent(article.getContent());
        }
        return editedArticle;
    }

    @Override
    public void delete(Integer id) {
        articles = articles.stream().filter(a -> a.getId() != id).collect(Collectors.toList());
    }

    private Integer findLastId() {
        Optional<Article> optional = articles.stream().max(Comparator.comparing(Article::getId));
        return optional.isPresent() ? optional.get().getId() : 0;
    }
}
