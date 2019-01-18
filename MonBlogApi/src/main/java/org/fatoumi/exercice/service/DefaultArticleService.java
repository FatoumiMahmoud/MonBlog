package org.fatoumi.exercice.service;

import org.fatoumi.exercice.entity.Article;
import org.fatoumi.exercice.entity.ArticleEntity;
import org.fatoumi.exercice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.Optional;

@Service
public class DefaultArticleService implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public Iterable<ArticleEntity> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article find(Integer id) {
        Optional<ArticleEntity> optionalArticleEntity = articleRepository.findById(id);
        return optionalArticleEntity.isPresent() ? optionalArticleEntity.get() : null;
    }

    @Override
    public Article create(Article article) {
        return articleRepository.save((ArticleEntity) article);
    }

    @Override
    public Article edit(Article article) {
        return articleRepository.save((ArticleEntity) article);
    }

    @Override
    public void delete(Integer id) {
        ArticleEntity article = (ArticleEntity) this.find(id);
        if (article != null) {
            articleRepository.delete(article);
        }
    }

    @Override
    public Article addComment(Integer id, Comment comment) {
        return null;
    }
}
