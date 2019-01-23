package org.fatoumi.exercice;

import org.fatoumi.exercice.entity.ArticleEntity;
import org.fatoumi.exercice.entity.CommentEntity;
import org.fatoumi.exercice.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {

    private static final Logger log = LoggerFactory.getLogger(DBConfig.class);

    @Bean
    public ApplicationRunner applicationRunner(ArticleRepository articleRepository) {
        return (ApplicationArguments args) -> {
            if (args.getOptionNames().contains("init")) {
                initArticle(articleRepository);
            }
        };
    }

    private void initArticle(ArticleRepository articleRepository) {
        log.info("Save a couple of articles ");
        log.info("--------------------------------------------");
        ArticleEntity article;
        CommentEntity c1, c2;

        article = new ArticleEntity("article 1", "artticle 1 content");
        c1 = new CommentEntity("Comment ....1", article);
        c2 = new CommentEntity("Comment ....2", article);
        article.getComments().add(c1);
        articleRepository.save(article);

        article = new ArticleEntity("article 2", "artticle 2 content");
        c1 = new CommentEntity("Comment ....3", article);
        c2 = new CommentEntity("Comment ....4", article);
        article.getComments().add(c1);
        article.getComments().add(c2);
        articleRepository.save(article);

        article = new ArticleEntity("article 3", "artticle 3 content");
        c1 = new CommentEntity("Comment ....5", article);
        c2 = new CommentEntity("Comment ....6", article);
        article.getComments().add(c1);
        article.getComments().add(c2);
        articleRepository.save(article);

        article = new ArticleEntity("article 4", "artticle 4 content");
        c1 = new CommentEntity("Comment ....7", article);
        c2 = new CommentEntity("Comment ....8", article);
        article.getComments().add(c1);
        article.getComments().add(c2);
        articleRepository.save(article);

        article = new ArticleEntity("article 5", "artticle 5 content");
        c1 = new CommentEntity("Comment ....9", article);
        c2 = new CommentEntity("Comment ....10", article);
        article.getComments().add(c1);
        article.getComments().add(c2);
        articleRepository.save(article);
        log.info("--------------------------------------------");
    }
}
