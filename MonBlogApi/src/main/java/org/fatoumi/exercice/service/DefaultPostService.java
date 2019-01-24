package org.fatoumi.exercice.service;

import org.fatoumi.exercice.entity.Post;
import org.fatoumi.exercice.entity.Comment;
import org.fatoumi.exercice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultPostService implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post find(Integer id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost.isPresent() ? optionalPost.get() : null;
    }

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post edit(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(Integer id) {
        Post post = this.find(id);
        if (post != null) {
            postRepository.delete(post);
        }
    }

    @Override
    public Post addComment(Integer id, Comment comment) {
        Post post = this.find(id);
        if (post != null) {
            post.getComments().add(comment);
            postRepository.save(post);
        }
        return post;
    }
}
