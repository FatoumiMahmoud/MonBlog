package org.fatoumi.exercice.article.service;

import org.fatoumi.exercice.article.Article2;
import org.fatoumi.exercice.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    public Iterable<Article2> findAll2() {
        return articleRepository.findAll();
    }

}
