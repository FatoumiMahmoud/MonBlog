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
            articleRepository.save(new ArticleEntity("article 1", "artticle 1 content"));
            articleRepository.save(new ArticleEntity("article 2", "artticle 2 content"));
            log.info("--------------------------------------------");

            log.info("Save a couple of comments ");
            commentRepository.save(new CommentEntity("Commment ....1"));
            commentRepository.save(new CommentEntity("Commment ....2"));
            commentRepository.save(new CommentEntity("Commment ....3"));
            commentRepository.save(new CommentEntity("Commment ....4"));
            commentRepository.save(new CommentEntity("Commment ....5"));
            commentRepository.save(new CommentEntity("Commment ....6"));
            commentRepository.save(new CommentEntity("Commment ....7"));
            commentRepository.save(new CommentEntity("Commment ....8"));
            commentRepository.save(new CommentEntity("Commment ....9"));
            commentRepository.save(new CommentEntity("Commment ....10"));
            log.info("--------------------------------------------");

        };

    }
}
