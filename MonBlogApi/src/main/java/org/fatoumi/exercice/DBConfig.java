package org.fatoumi.exercice;

import org.fatoumi.exercice.entity.Comment;
import org.fatoumi.exercice.entity.Post;
import org.fatoumi.exercice.repository.PostRepository;
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
    public ApplicationRunner applicationRunner(PostRepository postRepository) {
        return (ApplicationArguments args) -> {
            if (args.getOptionNames().contains("init")) {
                initPost(postRepository);
            }
        };
    }

    private void initPost(PostRepository postRepository) {
        log.info("Save a couple of Posts ");
        log.info("--------------------------------------------");
        Post post;
        Comment c1, c2;

        post = new Post("post 1", "artticle 1 content");
        c1 = new Comment("Comment ....1", post);
        c2 = new Comment("Comment ....2", post);
        post.getComments().add(c1);
        postRepository.save(post);

        post = new Post("post 2", "artticle 2 content");
        c1 = new Comment("Comment ....3", post);
        c2 = new Comment("Comment ....4", post);
        post.getComments().add(c1);
        post.getComments().add(c2);
        postRepository.save(post);

        post = new Post("post 3", "artticle 3 content");
        c1 = new Comment("Comment ....5", post);
        c2 = new Comment("Comment ....6", post);
        post.getComments().add(c1);
        post.getComments().add(c2);
        postRepository.save(post);

        post = new Post("post 4", "artticle 4 content");
        c1 = new Comment("Comment ....7", post);
        c2 = new Comment("Comment ....8", post);
        post.getComments().add(c1);
        post.getComments().add(c2);
        postRepository.save(post);

        post = new Post("post 5", "artticle 5 content");
        c1 = new Comment("Comment ....9", post);
        c2 = new Comment("Comment ....10", post);
        post.getComments().add(c1);
        post.getComments().add(c2);
        postRepository.save(post);
        log.info("--------------------------------------------");
    }
}
