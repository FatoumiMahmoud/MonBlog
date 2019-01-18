package org.fatoumi.exercice;

import org.fatoumi.exercice.article.Article2;
import org.fatoumi.exercice.article.repository.ArticleRepository;
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
    public CommandLineRunner demo(ArticleRepository articleRepository) {
        return (args) -> {
            log.info("Save a couple of articles ");
            articleRepository.save(new Article2("article 1", "artticle 1 content"));
            articleRepository.save(new Article2("article 2", "artticle 2 content"));
            log.info("--------------------------------------------");
        };

    }
}
