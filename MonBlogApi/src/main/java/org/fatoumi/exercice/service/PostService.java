package org.fatoumi.exercice.service;

import org.fatoumi.exercice.entity.Post;
import org.fatoumi.exercice.entity.Comment;

public interface PostService {

    /**
     * @return list off all posts
     */
    Iterable<Post> findAll();

    /**
     * @param id post id
     * @return the post with the id
     */
    Post find(Integer id);

    /**
     * @param Post the Post without id
     * @return the created Post
     */
    Post create(Post Post);

    /**
     * @param Post
     * @return the edited Post
     */
    Post edit(Post Post);

    /**
     * @param id post id to be deleted
     */
    void delete(Integer id);

    /**
     * @param id      post id
     * @param comment the commentMock to be added to the post
     * @return the post after modification
     */
    Post addComment(Integer id, Comment comment);
}
