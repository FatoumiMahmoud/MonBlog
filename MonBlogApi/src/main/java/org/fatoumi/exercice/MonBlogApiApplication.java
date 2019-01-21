package org.fatoumi.exercice;

import org.fatoumi.exercice.entity.ArticleEntity;
import org.fatoumi.exercice.entity.CommentEntity;
import org.fatoumi.exercice.repository.ArticleRepository;
import org.fatoumi.exercice.repository.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonBlogApiApplication {

    private static final Logger log = LoggerFactory.getLogger(MonBlogApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MonBlogApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ArticleRepository articleRepository, CommentRepository commentRepository) {
        return (args) -> {
            log.info("Save a couple of articles ");
            log.info("--------------------------------------------");

            ArticleEntity article = new ArticleEntity("article 1", "artticle 1 content");
            article.getComments().add(new CommentEntity("Commment ....1"));
            article.getComments().add(new CommentEntity("Commment ....2"));
            articleRepository.save(article);

            article = new ArticleEntity("article 2", "artticle 2 content");
            article.getComments().add(new CommentEntity("Commment ....3"));
            article.getComments().add(new CommentEntity("Commment ....4"));
            articleRepository.save(article);

            article = new ArticleEntity("article 3", "artticle 3 content");
            article.getComments().add(new CommentEntity("Commment ....5"));
            article.getComments().add(new CommentEntity("Commment ....6"));
            articleRepository.save(article);

            article = new ArticleEntity("article 4", "artticle 4 content");
            article.getComments().add(new CommentEntity("Commment ....7"));
            article.getComments().add(new CommentEntity("Commment ....8"));
            articleRepository.save(article);

            article = new ArticleEntity("article 5", "artticle 5 content");
            article.getComments().add(new CommentEntity("Commment ....9"));
            article.getComments().add(new CommentEntity("Commment ....10"));
            articleRepository.save(article);
            log.info("--------------------------------------------");

        };

    }
}
