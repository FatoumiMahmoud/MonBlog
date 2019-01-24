package org.fatoumi.exercice.service;

import org.fatoumi.exercice.entity.Article;
import org.fatoumi.exercice.entity.Comment;
import org.fatoumi.exercice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultArticleService implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Iterable<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article find(Integer id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        return optionalArticle.isPresent() ? optionalArticle.get() : null;
    }

    @Override
    public Article create(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article edit(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void delete(Integer id) {
        Article article = this.find(id);
        if (article != null) {
            articleRepository.delete(article);
        }
    }

    @Override
    public Article addComment(Integer id, Comment comment) {
        Article article = this.find(id);
        if (article != null) {
            article.getComments().add(comment);
            articleRepository.save(article);
        }
        return article;
    }
}
